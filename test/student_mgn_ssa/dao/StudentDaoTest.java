package student_mgn_ssa.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import student_mgn_ssa.dao.impl.StudentDaoImpl;
import student_mgn_ssa.dto.Student;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoTest {
	private static StudentDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = StudentDaoImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("테스트 메서드 시작 전 - setUp()");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("테스트 메서드 종료 후 - tearDown()");
		System.out.println();

	}

	@Test
	public void test01SelectStudentByAll() {
		System.out.println("testSelectStudentByAll()");
		ArrayList<Student> list = dao.selectStudentByAll();
		Assert.assertNotEquals(0, list.size());
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectStudentByNo() {
		System.out.println("testSelectStudentByNo()");
		Student selectStudent = dao.selectStudentByNo(new Student(1001));
		Assert.assertNotNull(selectStudent);
		System.out.println(selectStudent);
	}

	@Test
	public void test03InsertStudent() {
		System.out.println("testInsertStudent()");	
		Student newStd = new Student(1003, "최영지", 75, 75, 95);
		int res = dao.insertStudent(newStd);
		Assert.assertEquals(1, res);
		
		
		dao.deleteStudent(newStd);
		
		
		
	}

	@Test
	public void test04UpdateStudent() {		
		System.out.println("testUpdateStudent()");
		//1. 추가
		Student std = new Student(1003, "최영지", 75, 75, 95);
		dao.insertStudent(std);
		
		//2.수정(검증)
		std.setStdName("고지숙");
		std.setKor(83);
		std.setEng(76);
		std.setMath(82);
		int res = dao.updateStudent(std);
		Assert.assertEquals(1, res);
		
		//변경유무 출력
		Student selStudent = dao.selectStudentByNo(std);
		System.out.println(selStudent);
		
		//3.삭제
		dao.deleteStudent(std);
		
		
		
	}

	@Test
	public void test05DeleteStudent() {
		System.out.println("testDeleteStudent()");
		Student std = new Student(1003, "최영지", 75, 75, 95);
		dao.insertStudent(std);
		
		int res = dao.deleteStudent(std);
		Assert.assertEquals(1, res);
		
	}

}
