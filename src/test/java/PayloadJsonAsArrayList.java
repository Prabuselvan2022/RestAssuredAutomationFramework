import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class PayloadJsonAsArrayList {

	@BeforeClass
	public void beforeClass() {
			
		RequestSpecBuilder  reqspecbuilder=  new RequestSpecBuilder()
				.setBaseUri("https://api.postman.com")
				.setContentType(ContentType.JSON)
				
				.log(LogDetail.ALL);
		
		RestAssured.requestSpecification = reqspecbuilder.build();
		
		
		ResponseSpecBuilder respspecbuilder=  new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON);
		
		RestAssured.responseSpecification = respspecbuilder.build();
		
	}
	
	
	@Test
	public void validate_post_request_payload_json_array_as_a_list() {
		
	}
	
}
