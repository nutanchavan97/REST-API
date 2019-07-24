package com.amdocs.demo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = DemoApplication.class)
public class StepDef {

	String url;
	Double result;
	
	@Given("A REST url as {string}")
	public void a_REST_url_as(String string) {
	    url = string;
	}

	@When("invoking REST API for addition")
	public void invoking_REST_API_for_addition() {
	    RestTemplate restTemplate = new RestTemplate();
	    result = restTemplate.getForObject(url, Double.class);
	}

	@Then("expected result is {string}")
	public void expected_result_is(String string) {
	    assertEquals(Double.parseDouble(string), result, 0.01);
	}


}
