package com.ferreirae.code401d4.day12.firstWebApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FirstWebAppApplicationTests {

	@Autowired
	GreetingController greetingController;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testControllerIsAutowired() {
		assertNotNull(greetingController);
	}

	@Test
	public void testRequestToRootGivesHelloWorld() throws Exception {
		mockMvc.perform(get("/")).andExpect(content().string(containsString("Hello, world! It's a beautiful day!")));
	}

}
