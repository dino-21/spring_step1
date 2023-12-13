package com.dino.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dino.domain.TestVO;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
public class TestMapperTest {

	@Autowired
	private TestMapper testMapper;

//	@Test
//	public void testgetTime() {
//		log.info(">>>>" + testMapper.getTime());
//	}
//
//	@Test
//	public void testInsert() {
//		TestVO vo = TestVO.builder().title("테스트 제목1").content("테스트 내용1").build();
//
//		int result = testMapper.insert(vo);
//		log.info(">>>>>>" + result);
//	}

//	@Test
//	public void testGetList() {
//		  List<TestVO> lists = testMapper.getList();
//		    for (TestVO testVO : lists)
//		        log.info(testVO.toString());
//		
//		// log.info(">>>> List: " + testMapper.getList());
//	}
//	
//	@Test
//	public void testgetOne() {
//	    TestVO record = testMapper.getOne(1);
//	    log.info(">>>>>> Retrieved Record: " + record);
//	}
	
//	@Test
//    public void testUpdate() {
//	TestVO vo = TestVO.builder().id(1) // 업데이트할 번호 id 1
//		.title("업데이트된 제목1")
//                     .content("업데이트된 내용1")
//                     .build();
//
//		int result = testMapper.update(vo);
//		log.info(">>>>>> Update result: " + result);
//	}
	
	@Test
	public void testDelete() {
		int idToDelete = 1; // 삭제할 번호 id 1
		int result = testMapper.delete(idToDelete);
		log.info(">>>>>> Delete result: " + result);
	}

}
