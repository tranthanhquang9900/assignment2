package vn.edu.vnuk.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.Lecturer;
import vn.edu.vnuk.model.Lecturer.LecturerBuilder;


public class LecturerTest {
	private final double delta = 0.0001;
	
	Lecturer L;
	
	@Before
	public void test_builder() {
		L = new Lecturer.LecturerBuilder(Define.latestId, Define.TYPE_OF_LECTURER)
				.setName("Quang")
				.setYearOfBirth(1999)
				.setHometown("Da Nang")
				.setDepartment("IBM")
				.setPeriodsInMonth(25)
				.setSalaryRatio((float) 2.5)
				.setAllowance(Define.ALLOWANCE_OF_BACHELOR)
				.setQualification(Define.POSITION_OF_CHIEF)
				.setYearOfWork(30)
				.setSalaryRatio(Define.DEFAULT_MINIMUM_WAGE)
				.build();
	}
	
	@Test
	public void testBuilderSetAllowanceWithBachelor() {
		L = new  Lecturer.LecturerBuilder(Define.latestId, Define.TYPE_OF_LECTURER)
			.setQualification(Define.QUALIFICATION_OF_BACHELOR)
			.setAllowance(Define.ALLOWANCE_OF_BACHELOR)
			.build();
	}
	
	@Test
	public void testBuilderSetAllowanceWithMaster() {
		L = new Lecturer.LecturerBuilder(Define.latestId, Define.TYPE_OF_LECTURER)
			.setQualification(Define.QUALIFICATION_OF_DOCTOR)
			.setAllowance(Define.ALLOWANCE_OF_DOCTOR)
			.build();
	}
	
	@Test
	public void test_toString() {
		assertEquals(L.toString(),"Lecturer [hometown=Da Nang, department=IBM, salaryRatio=730.0, allowance=1000, position=Chief, workDay=25, yearOfWork=30, minimumWage=0.0, id=0, yearOfBirth=1999, type=1, name=Quang]" );
	}
	
	@Test
	public void test_Staff() {
		Lecturer L = new Lecturer();
		assertNotNull(L);
	}
	
	@Test
	public void test_getID() {
		assertEquals(0 , L.getId());
	}
	
	@Test
	public void test_setName() {
		L.setName("Quang");
		assertEquals("Quang" , L.getName());
	}
	
	@Test
	public void test_setYearOfBirth() {
		L.setYearOfBirth(1999);
		assertEquals(1999 , L.getYearOfBirth());
	}
	
	@Test
	public void test_getType() {
		assertEquals(1 , L.getType());
	}
	
	@Test
	public void test_SetHomeTown() {
		L.setHometown("Da Nang");
		assertEquals("Da Nang" , L.getHometown());
	}
	
	@Test
	public void test_setDepartment() {
		L.setDepartment("IBM");
		assertEquals("IBM" , L.getDepartment());
	}
	
	@Test
	public void test_setWorkDay() {
		L.setPeriodsInMonth(25);
		assertEquals(25 , L.getPeriodsInMonth() , delta);
	}
	
	@Test
	public void test_setSalaryRatio() {
		L.setSalaryRatio((float) 2.5);
		assertEquals(2.5 , L.getSalaryRatio() , delta);
	}
	
	@Test
	public void test_setAllowanceOfBachelor() {
		L.setAllowance(Define.ALLOWANCE_OF_BACHELOR);
		assertEquals(300 , L.getAllowance() , delta);
	}
	
	@Test
	public void test_setAllowanceOfDoctor() {
		L.setAllowance(Define.ALLOWANCE_OF_DOCTOR);
		assertEquals(2000 , L.getAllowance() , delta);
	}
	
	@Test
	public void test_setAllowanceOfMaster() {
		L.setAllowance(Define.ALLOWANCE_OF_MASTER);
		assertEquals(900 , L.getAllowance() , delta);
	}
	
	@Test
	public void test_setPositionOfBachelor() {
		L.setQualification(Define.QUALIFICATION_OF_BACHELOR);
		assertEquals("Bachelor" , L.getQualification());
	}
	
	@Test 
	public void test_setPositionOfDoctor() {
		L.setQualification(Define.QUALIFICATION_OF_DOCTOR);
		assertEquals("DOCTOR" , L.getQualification());
	}
	
	@Test
	public void test_setPositionOfMaster() {
		L.setQualification(Define.QUALIFICATION_OF_MASTER);
		assertEquals("MASTER" , L.getQualification());
	}
	
	@Test
	public void test_setYearsOfWork() {
		L.setYearOfWork(25);
		assertEquals(25 , L.getYearOfWork() , delta);
	}
	
	@Test
	public void test_setBasicSalary() {
		L.setSalaryRatio(25000);
		assertEquals(25000 , L.getSalaryRatio() , delta);
	}
	@Test
	public void test_update() {
		L.update(730);
		assertEquals(730 , L.getSalaryRatio() , delta);
	}
	
	@Test
	public void test_getSalary() {
		assertEquals(1425,L.getSalary() , delta);
	}
}