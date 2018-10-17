package study.spring.hellospring.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.hellospring.model.Professor;
import study.spring.hellospring.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	/** MyBatis의 Mapper를 호출하기 위한 SqlSession 객체 */
	// Spring으로 부터 주입받는다.
	// --> import org.springframework.beans.factory.annotation.Autowired;
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addProfessor(Professor professor) throws Exception {
		try {
			// [MyBatisMapper에 정의한 기능] 가능을 호출한다.
			// 두 번째 파라미터는 저장할 데이터를 담고 있는 Beans객체
			int result = sqlSession.insert("ProfessorMapper.add_Professor", professor);
			
			// 리턴값은 저장된 행의 수
			if (result == 0) {
				// 저장된 행이 없다면 강제로 예외를 발생시킨다.
				// --> 이 예외를 처리 가능한 catch블록으로 제어가 이동한다.
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("저장된 데이터가 없습니다.");
		} catch (Exception e) {
			throw new Exception("데이터 저장에 실패했습니다.");
		}
		
	}

	@Override
	public void editProfessor(Professor professor) throws Exception {
		try {
			// [MyBatisMapper에 정의한 기능] 가능을 호출한다.
			// 두 번째 파라미터는 저장할 데이터를 담고 있는 Beans객체
			int result = sqlSession.update("ProfessorMapper.edit_Professor", professor);
			
			// 리턴값은 저장된 행의 수
			if (result == 0) {
				// 저장된 행이 없다면 강제로 예외를 발생시킨다.
				// --> 이 예외를 처리 가능한 catch블록으로 제어가 이동한다.
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("수정된 데이터가 없습니다.");
		} catch (Exception e) {
			throw new Exception("데이터 수정에 실패했습니다.");
		}
	}

	@Override
	public void deleteProfessor(Professor professor) throws Exception {
		try {
			// [MyBatisMapper에 정의한 기능] 가능을 호출한다.
			// 두 번째 파라미터는 저장할 데이터를 담고 있는 Beans객체
			int result = sqlSession.delete("ProfessorMapper.remove_Professor", professor);
			
			// 리턴값은 저장된 행의 수
			if (result == 0) {
				// 저장된 행이 없다면 강제로 예외를 발생시킨다.
				// --> 이 예외를 처리 가능한 catch블록으로 제어가 이동한다.
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			throw new Exception("데이터 삭제에 실패했습니다.");
		}
		
	}

	@Override
	public Professor getProfessorItem(Professor professor) throws Exception {
		Professor result = null;
		
		try {
			// MyBatis의 데이터 조회 결과를 미리 준비한 객체에 저장한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans객체
			result = sqlSession.selectOne("get_Professor_item", professor);
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
	public List<Professor> getProfessorList(Professor professor) throws Exception {
		List<Professor> result = null;
		
		try {
			// MyBatis의 데이터 조회 결과를 미리 준비한 객체에 저장한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans객체
			result = sqlSession.selectList("get_Professor_list", professor);
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

}
