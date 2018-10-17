package study.spring.hellospring.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.hellospring.model.StudentDepartmentProfessor;
import study.spring.hellospring.service.StudentJoinService;

@Service
public class StudentJoinServiceImpl implements StudentJoinService {
	
	/** MyBatis의 Mapper를 호출하기 위한 SqlSession 객체 */
	// Spring으로 부터 주입받는다.
	// --> import org.springframework.beans.factory.annotation.Autowired;
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public StudentDepartmentProfessor get_StudentJoin_item(StudentDepartmentProfessor student) throws Exception {
		StudentDepartmentProfessor result = null;
		
		try {
			// MyBatis의 데이터 조회 결과를 미리 준비한 객체에 저장한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans객체
			result = sqlSession.selectOne("StudentJoinMapper.get_StudentJoin_item", student);
			// 조회 결과가 없을 경우 강제로 예외를 발생시킨다.
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			// 조회결과가 없을 경우 사용자에게 전달될 메시지를 설정한다.
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public List<StudentDepartmentProfessor> get_StudentJoin_list(StudentDepartmentProfessor student) throws Exception {
		List<StudentDepartmentProfessor> result = null;
		
		try {
			// MyBatis의 데이터 조회 결과를 미리 준비한 객체에 저장한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans객체
			result = sqlSession.selectList("StudentJoinMapper.get_StudentJoin_list", student);
			// 조회 결과가 없을 경우 강제로 예외를 발생시킨다.
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			// 조회결과가 없을 경우 사용자에게 전달될 메시지를 설정한다.
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			throw new Exception("데이터 조회에 실패했습니다.");
		}		
		
		return result;
	}

	@Override
	public int getStudentCount(StudentDepartmentProfessor student) throws Exception {
		int result = 0;
		
		try {
			// MyBatis의 데이터 조회 결과를 미리 준비한 객체에 저장한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans객체
			result = sqlSession.selectOne("StudentJoinMapper.selectStudentCount", student);
		} catch (Exception e) {
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		
		return result;
	}

}
