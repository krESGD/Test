package study.spring.hellospring;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import study.spring.hellospring.model.StudentDepartmentProfessor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class StudentSelectItemTest {
	
	@Autowired
	private SqlSession sqlSession;	// 객체주입
	
	@Test
	public void testFaxtory() {
		
		// 조회할 데이터의 조건값 설정
		StudentDepartmentProfessor student = new StudentDepartmentProfessor();
		student.setStudno(10101);
		
		// 조회결과가 저장될 객체
		StudentDepartmentProfessor result = null;
		
		try {
			result = sqlSession.selectOne("StudentJoinMapper.get_StudentJoin_item", student);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.println("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("데이터 조회에 실패했습니다.");
		}
		
		System.out.println(result.toString());
	}
}
