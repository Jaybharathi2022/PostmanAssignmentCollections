package week4.day1.assignment;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIssueJIRA extends BaseRestImpl{
	
	@Test
	public void sendPostRequest() {
		inputRequest
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
		
		Response response=inputRequest.post();
		
		validatableResponse=response.then();		
		
		issue_id = response.jsonPath().getString("id");
	
		validatableResponse.assertThat().statusCode(201);
	}

}
