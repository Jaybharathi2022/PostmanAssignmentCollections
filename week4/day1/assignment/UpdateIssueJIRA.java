package week4.day1.assignment;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIssueJIRA extends BaseRestImpl{
	
	@Test(dependsOnMethods="week4.day1.assignment.CreateIssueJIRA.sendPostRequest")
	public void sendPUTRequest() {
		inputRequest
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "\r\n"
				+ "        \"description\": \"Update REST API for testing from Rest-Assured\"\r\n"
				+ "    }\r\n"
				+ "}");
		
		Response response= inputRequest.put(issue_id);
		validatableResponse=response.then();
		
		
		validatableResponse
		.assertThat()
		.statusCode(204);
	}

}
