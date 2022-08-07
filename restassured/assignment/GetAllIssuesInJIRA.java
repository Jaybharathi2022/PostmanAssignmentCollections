package week3.restassured.assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIssuesInJIRA {

	@Test
	public void sendGetRequest() {
		
		
		
		RestAssured.baseURI="https://jayabharathi.atlassian.net/rest/api/2/search";
		RequestSpecification inputRequest = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic("jayabharathi.ushab@gmail.com", "iE3xhqHGiZJEQ3QRiFa76779")
				.accept(ContentType.JSON);
		Response response = inputRequest.get("?jql=project=\"AP\"");
		response.then().assertThat().statusCode(200);
		response.prettyPrint();
		
		
	}
}
