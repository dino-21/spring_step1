package com.dino.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit 테스트 시에 스프링이 제공하는 테스트 컨텍스트 프레임워크를 사용하도록 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 애노테이션은 테스트에 사용할 스프링 설정 파일의 위치를 지정
@Log4j // 롬복의 애노테이션. log 변수를 사용하여 로그를 출력
public class DataSourceTest {
	@Autowired // 스프링에게 해당 필드를 자동으로 주입, 데이터 소스를 주입
	private DataSource datasource;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	// 데이터 소스를 사용하여 데이터베이스 연결을 시도하는 메서드
	@Test // JUnit 프레임워크에 속하는 애노테이션, 테스트 메서드로 인식, 데이터 소스 연결을 테스트하는 메서드
	public void testConnection() { // testConnection() 데이터 소스를 사용하여 데이터베이스 연결을 시도하는 메서드
		try (Connection con = datasource.getConnection()) { // try-with-resources 구문을 사용하여 데이터 소스로부터 연결을 얻고
			log.info(">>>>>2" + con); // 데이터베이스 연결이 성공하면 로그에 메시지를 출력
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mybatisConnection() {
		// MyBatis SqlSessionFactory를 사용하여 데이터베이스 연결을 시도하는 메서드
		try (SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection()) {
			log.info("session >>>>> " + session);
			log.info("con >>>>> " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
