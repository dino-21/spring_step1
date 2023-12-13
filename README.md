# Spring_Mybatis4

# mybatis_CRUD


mybatis와 스프링 CRUD 작업


https://mybatis.org/mybatis-3/ko/sqlmap-xml.html

Log4jdbc-log4j (sql문 직관적으로 보는 라이브러리 설치)

https://blog.naver.com/ysboo2/223283608361



프로젝트 구조

![75](https://github.com/dino-21/Spring_Mybatis4/assets/80396471/5da356dc-b350-4a5f-a033-6cddf55da7c2)




Mybatis 스프링 연동해서 CRUD하기  - 목차


1. mysql DB 준비

2. 롬복깔기 –스프링에 깔았는지 확인

3. STS에서 스프링 프로젝트 깔기
- 자바11, 톰캣 9.0확인
- 메이븐 강제 업데이트 

4. pom.xml  라이브러리 3개 깔기 
  JDBC  dependency / Test 
 메이븐 사이트에서 라이브러리 검색
 https://mvnrepository.com/

5. home.jsp  실행

6. JDBCTest.java파일 만들어서 JDBC 연결 
콘솔로 mysql연결됐는지 확인

7. HikariCP 데이터베이스 커넥션 풀을 설정하는 부분
   root-context.xml 파일 수정  (HikariCP빈등록)

8. 커넥션 풀 HikariCP
  DataSourceTest.java 작업(어노테이션, 롬복 사용)
  콘솔창에서 DB 커넥션 풀 성공 메시지 확인

9. Junit 버전 4.12인지 pom.xml확인
   롬복개념이해

10. pom.xml 라이브러리 2개 추가 
    SQL과 자바 객체 매핑 
   - mybatis, mybatis Spring (3.0.0이상이면 에러)
   메이븐 사이트에서 라이브러리 검색
   https://mvnrepository.com/

11. SQLSessionFactory 빈 등록하기
root-context.xml 파일에서 아래쪽
> namespaces 클릭> mybatis-spring-http://mybatis.org/schema/mybatis-spring
체크박스 체크하고 코드에 빈등록하기

12. SqlSessionFactory 작업
MyBatis SqlSessionFactory의 연결을 테스트하는 코드작업
DataSourceTest.java파일 수정하기


13. Mapper 인터페이스 파일 만들기(SQL 쿼리를 정의하고 매핑)


패키지명
목적 및 기능
src/main/java
소스코드
src/main/resources 
리소스파일저장, 이미지, 
xml파일, 프로퍼티 파일 저장, 정적데이터
src/test/java
테스크 코드를 저장, 안정성 및 기능 검증




14. TestMpper.xml파일 만들기
<mybatis-spring:scan>은 MyBatis와 Spring을 통합할 때 Mapper 인터페이스를 자동으로 찾아 MyBatis에 등록하는 역할

15. Spring과 MyBatis를 통합한 환경에서 TestMapper의 getTime() 메서드를 테스트하는 클래스
testTetTime 메서드에서 getTime() 메서드를 호출하고 결과를 로그에 출력한다.

16. pom.xml에서 log4jdbc-log4j2 설정 
   SQL 쿼리를 직관적 확인하는 라이브러리

17. 로그 설정파일 추가 -log4jdbc.log4j2.properties
log4jdbc.log4j2.properties 파일안에 코드 추가
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator


18. jdbc연결정보 수정 – root-context.xml 파일수정
  <bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
         <property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy" />
         <property name="jdbcUrl" value="jdbc:log4jdbc:mysql://localhost:3306/bbs" />
         <property name="username" value="root"/>
         <property name="password" value="1234"/>
     </bean>		
     

19. TestMapperTest.java에서 실행해서 콘솔창에서 sql문 확인하기

20.  CRUD하기 위해 TestVO.java만들기
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestVO {
  private int id;
  private String title;
  private String content;
}

21. TestMapper의 메서드를 테스트하는 코드 작성

TestMapper.java 
인터페이스 메서드
MyBatis 매퍼(interface)로, 데이터베이스에 대한 쿼리를 정의하는 역할
TestMapper.xml 
(xml 맵핑)
MyBatis XML 파일로, TestMapper.java의 메서드와 SQL 쿼리를 매핑
TestMapperTest.java (테스트 코드)
테스트 코드


JUnit을 사용하여 TestMapper의 메서드를 테스트하는 코드
Spring과 MyBatis를 통합한 환경에서 TestMapper의 getTime() 메서드를 호출하고 결과를 출력

22. getlist, insert, update, delete 작성하고 mysql에서 확인하기 
