package study.spring.hellospring.service;

import java.util.List;

import study.spring.hellospring.model.StudentDepartmentProfessor;

public interface StudentJoinService {
	/**
	 * 학생 상세 조회
	 * @param student 조회할 학생의 일련번호를 담고 있는 Beans
	 * @return 조회된 데이터가 저장된 Beans
	 * @throws Exception
	 */
	public StudentDepartmentProfessor get_StudentJoin_item(StudentDepartmentProfessor student)
		throws Exception;
	
	/**
	 * 학생 목록 조회
	 * @param professor 조회결과에 대한 컬렉션
	 * @throws Exception
	 */
	// -> import java.util.List;
	public List<StudentDepartmentProfessor> get_StudentJoin_list(StudentDepartmentProfessor student)
		throws Exception;
	
	
	/**
	 * 전체 목록 수 조회
	 * @return 조회결과
	 * @throws Exception
	 */
	public int getStudentCount(StudentDepartmentProfessor student) throws Exception;
}
