package student_mgn_ssa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student_mgn_ssa.dao.StudentDao;
import student_mgn_ssa.dto.Student;
import student_mgn_ssa.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {
	private static final StudentDaoImpl instance = new StudentDaoImpl();

	public static StudentDaoImpl getInstance() {
		return instance;
	}

	private StudentDaoImpl() {
	}

	@Override
	public ArrayList<Student> selectStudentByAll() {
//		1.db접속(시간많이 걸림) <- Connection pool = Connection
//		2.sql을 데이터베이스에 맞는 코드로준비(스트링을 명령문으로 변경) = PreparedStatement
//		3.sql에서 ?를 입력 매개변수값으로 치환해서 sql명령문을 완성
//		4.sql명령문 실행(select : executeQuery
//						insert,update,delete : executeUpdate)
//		5.만약 executeQuery일경우 :sql결과(Result set)를 클래스로 변환
		String sql = "SELECT stdno, stdname, kor, eng, math FROM student";
		ArrayList<Student> list = null;
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			list = new ArrayList<Student>();
			while (rs.next()) {
				list.add(getStudent(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Student selectStudentByNo(Student std) {
		String sql = "SELECT stdno, stdname, kor, eng, math FROM student WHERE stdno=?";
			try(Connection con = JdbcUtil.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, std.getStdNo());
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						return getStudent(rs);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	private Student getStudent(ResultSet rs) throws SQLException {
//		stdno, stdname, kor, eng, math
		int stdNo = rs.getInt("stdno");
		String stdName = rs.getString("stdname");
		int kor = rs.getInt("kor");
		int eng = rs.getInt("eng");
		int math = rs.getInt("math");
		return new Student(stdNo, stdName, kor, eng, math);
	}
	
	@Override
	public int insertStudent(Student std) {
//		stdno, stdname, kor, eng, math
		String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, std.getStdNo());
			pstmt.setString(2, std.getStdName());
			pstmt.setInt(3, std.getKor());
			pstmt.setInt(4, std.getEng());
			pstmt.setInt(5, std.getMath());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public int updateStudent(Student std) {
		String sql = "UPDATE student SET stdname=?, kor=?, eng=?, math=? WHERE stdno=?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, std.getStdName());
			pstmt.setInt(2, std.getKor());
			pstmt.setInt(3, std.getEng());
			pstmt.setInt(4, std.getMath());
			pstmt.setInt(5, std.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(Student std) {
		String sql = "DELETE FROM student WHERE stdno=?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, std.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
