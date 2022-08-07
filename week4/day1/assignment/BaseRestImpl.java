package week4.day1.assignment;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BaseRestImpl {

	public static String issue_id;
	public static RequestSpecification inputRequest;
	public static Response response;
	public static ValidatableResponse validatableResponse;

	@BeforeSuite
	public void setPreConfig() {
		RestAssured.baseURI = "https://jayabharathi.atlassian.net/rest/api/2/issue/";
		inputRequest = RestAssured
				.given()
				.log()
				.all()
				.auth()
				.preemptive()
				.basic("jayabharathi.ushab@gmail.com", "nk6Sij0nBm771vpZnZB0EE88");
	}
	
	@AfterMethod
	public void setPostConfig() {
		validatableResponse.log().all();
	}

}
