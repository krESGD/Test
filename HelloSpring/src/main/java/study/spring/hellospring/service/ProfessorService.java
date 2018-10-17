package study.spring.hellospring.service;

import java.util.List;

import study.spring.hellospring.model.Professor;

/** 교수 관리 기능을 제공하기 위한 Service 계층. */
public interface ProfessorService {
	
	/**
	 * 교수 등록하기
	 * @param professor 저장할 정보 담고 있는 Beans
	 * @throws Exception
	 */
	// --> import study.spring.hellospring.model.Professor;
	public void addProfessor(Professor professor) throws Exception;
	
	
	/**
	 * 교수 수정하기
	 * @param professor 수정할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	public void editProfessor(Professor professor) throws Exception;
	
	
	/**
	 * 교수 삭제하기
	 * @param professor 삭제할 교수의 일련번호를 담고 있는 Beans
	 * @throws Exception
	 */
	public void deleteProfessor(Professor professor) throws Exception;
		
	/**
	 * 교수 상세 조회
	 * @param professor 조회할 교수의 일련번호를 담고 있는 Beans
	 * @return
	 * @throws Exception
	 */
	public Professor getProfessorItem(Professor professor) throws Exception;
	
	
	/**
	 * 교수 목록 조회
	 * @param professor 조회 결과에 대한 컬렉션
	 * @throws Exception
	 */
	public List<Professor> getProfessorList(Professor professor) throws Exception;
}
