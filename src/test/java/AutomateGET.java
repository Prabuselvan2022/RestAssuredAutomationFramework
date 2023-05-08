import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
public class AutomateGET {

	@Test
	public void getAutomation() {
		
		given().baseUri("https://api.postman.com")
		.header("x-api-key","PMAK-64575904fb91c462f8197e3a-aa443acd0efc4936244e752b1582a97e36")
		.when()
		.get("/workspaces")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("workspaces.name", hasItems("My Workspace","Team Workspace","TestWorkspace","My Workspace003","My Workspace004"),
				"workspaces.type", hasItems("personal","team"),
				"workspaces.size()", equalTo(5));
			
	}
	
	@Test
	public void getResponse() {
		Response res = given().baseUri("https://api.postman.com")
		.header("x-api-key","PMAK-64575904fb91c462f8197e3a-aa443acd0efc4936244e752b1582a97e36")
		.when().log().all()
		.get("/workspaces")
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();

		System.out.println(res.asString());
	}
	
	@Test
	public void getResponse_onlyifError() {
		Response res = given().baseUri("https://api.postman.com")
		.header("x-api-key","MAK-64575904fb91c462f8197e3a-aa443acd0efc4936244e752b1582a97e36")
		.when().log().all()
		.get("/workspaces")
		.then().log().ifError()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();

//		System.out.println(res.asString());
	}
	
	@Test
	public void getResponse_onlyifValidationFails() {
		
		HashMap<String, String> headers =  new HashMap<String, String>();
		headers.put("x-api-key", "PMAK-64575904fb91c462f8197e3a-aa443acd0efc4936244e752b1582a97e36");
		Response res = given().baseUri("https://api.postman.com")
		.headers(headers)
		.when().log().ifValidationFails()
		.get("/workspaces")
		.then().log().ifValidationFails()
		.assertThat()
		.statusCode(400)
		.extract()
		.response();

//		System.out.println(res.asString());
	}
	
	@Test
	public void validate_post_request_payload_from_file() {
		
		File payload=  new File("/Users/prabuselvan/eclipse-workspace/RestAPIAutomation/src/test/resources/createworkspace.json");
		
		given().baseUri("https://api.postman.com")
		.header("x-api-key","PMAK-64575904fb91c462f8197e3a-aa443acd0efc4936244e752b1582a97e36")
		.body(payload)
		.when()
		.post("/workspaces")
		.then()
		.log().all()
		.assertThat()
		.body("workspace.name", equalTo("myFirstWorkspace"));
		
	}
}
