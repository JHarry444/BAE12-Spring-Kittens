package com.qa.kittens.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.kittens.data.Kitten;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // try random ports until it finds a free one
@AutoConfigureMockMvc
public class KittenControllerIntegrationTest {

	@Autowired // tells Spring to inject the MockMVC object into this class
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper; // yanks the class Spring uses to convert java to JSON

	@Test
	void testCreate() throws Exception {
		Kitten testKit = new Kitten("Jess", "Black and White", 57, 10);
		// convert to json
		String testKitAsJSON = this.mapper.writeValueAsString(testKit);

		System.out.println(testKit);
		System.out.println(testKitAsJSON);

		// body, method, address and the content-type header
		RequestBuilder request = post("/createKitten").contentType(MediaType.APPLICATION_JSON).content(testKitAsJSON);

		// check the response body and status

		ResultMatcher checkStatus = status().is(200);

		Kitten testCreatedKit = new Kitten("Jess", "Black and White", 57, 10);
		testCreatedKit.setId(1); // due to the AUTO_INCREMENT
		String testCreatedKitAsJSON = this.mapper.writeValueAsString(testCreatedKit);

		ResultMatcher checkBody = content().json(testCreatedKitAsJSON);
// SEND request and check status + body
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	void testCreateAbridged() throws Exception {
		this.mockMVC
				.perform(post("/createKitten").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(new Kitten("Jess", "Black and White", 57, 10))))
				.andExpect(status().is(201)).andExpect(content()
						.json(this.mapper.writeValueAsString(new Kitten(1, "Jess", "Black and White", 57, 10))));
	}
}
