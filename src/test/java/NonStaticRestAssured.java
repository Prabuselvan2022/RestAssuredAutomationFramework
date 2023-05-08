
import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class NonStaticRestAssured {
	public static String baseURL="https://8b64ae5c-4a37-4099-bbb3-c36d25d39065.mock.pstmn.io";
	

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void simpletest() {
		
		
	
		RestAssured.given()
				   .baseUri(baseURL)
//				   .header("x-api-key","PMAK-64575904fb91c462f8197e3a-aa443acd0efc4936244e752b1582a97e36")
		
		.when()
//		.get("/workspaces")
		.then()
		.statusCode(200)
		.body("mss", is(equals("successful")));
			
	}
}
