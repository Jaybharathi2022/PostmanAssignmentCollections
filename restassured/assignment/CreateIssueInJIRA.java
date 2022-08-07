package week3.restassured.assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIssueInJIRA {
	
	@Test
	public void sendPOst() {
		
		RestAssured.baseURI="https://jayabharathi.atlassian.net/rest/api/2/issue/";
		RequestSpecification inputRequest = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic("jayabharathi.ushab@gmail.com", "Uaa8Hz1QW6jcAj1NLO3G9AD8")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"fields\": {\r\n"
						+ "    \"project\":\r\n"
						+ "                {\r\n"
						+ "                    \"key\": \"AP\"\r\n"
						+ "                },\r\n"
						+ "    \"summary\": \"create bug in project\",\r\n"
						+ "    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
						+ "    \"issuetype\": {\r\n"
						+ "                    \"name\": \"Task\"\r\n"
						+ "                }\r\n"
						+ "    }\r\n"
						+ "}\r\n"
						+ "");
		Response response = inputRequest.post();
		//response.prettyPrint();
		//System.out.println("----Status Code-------: "+response.getStatusCode());
		
		response.then()
		.assertThat().statusCode(201);
		System.out.println("---------ID-------"+response.jsonPath().get("id"));
		
		
	}

}
