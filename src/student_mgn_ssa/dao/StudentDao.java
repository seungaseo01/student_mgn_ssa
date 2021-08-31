package student_mgn_ssa.dao;

import java.util.ArrayList;

import student_mgn_ssa.dto.Student;

public interface StudentDao {
	ArrayList<Student> selectStudentByAll();
	Student selectStudentByNo(Student std);

	int insertStudent(Student std);
	int updateStudent(Student std);
	int deleteStudent(Student std);
}
