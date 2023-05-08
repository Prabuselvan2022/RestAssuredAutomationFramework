import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class StaticRestAssured {

	public static String baseURL="https://8b64ae5c-4a37-4099-bbb3-c36d25d39065.mock.pstmn.io";
	@Test
	public void simple_test() {
		
		given()
		.baseUri(baseURL)
		.header("","")
		.params("","")
		.when()
		.get()
		.then()
		.statusCode(200)
		.body("msg", is(equalTo("successful")));
		
	}
}
