package week4.day1.assignment;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteIssueJIRA extends BaseRestImpl{
	
	@Test(dependsOnMethods="week4.day1.assignment.UpdateIssueJIRA.sendPUTRequest")
	public void sendDeleteRequest() {
		Response response= inputRequest.delete(issue_id);
		validatableResponse=response.then();
		
		
		validatableResponse.assertThat().statusCode(204);
	}

}
