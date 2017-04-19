package org.zerock.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; //MockMvcRequestBuilders안써주기
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" })
@WebAppConfiguration
public class SampleControllerTest {

	@Inject
	WebApplicationContext ctx;

	MockMvc mockMvc; // 가짜 웹어플리케이션 컨텍스트

	@Before // junit의 before 모든 테스트 시작하기 전에 가짜 리퀘스트를 만들것이다.
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

	}

	@Test
	public void testLoad() throws Exception {

		mockMvc.perform(get("/sample/doA"));

	}
	
	@Test
	public void testDB()throws Exception{
		
		mockMvc.perform(post("/sample/doA").param("title", "한글데이터").param("cotent", "ㅁㄴㅇㅁㄴ어ㅣ마"));
		
		
		
	}
	
	@Test
	public void testDB2()throws Exception{
		
//		int status = mockMvc.perform(get("/sample/doA").param("title", "한글데이터").
//				param("cotent", "ㅁㄴㅇㅁㄴ어ㅣ마")).andReturn().getResponse().getStatus();
		//builder패턴
		
		MvcResult result =  mockMvc.perform(get("/sample/doA")).andReturn();
		
		ModelAndView mav = result.getModelAndView();
		
		System.out.println(mav.getModel());
		System.out.println(mav.getViewName());
		
		int status = result.getResponse().getStatus();
		
		System.out.println("STATUS " + status);
		
		
	}

}
