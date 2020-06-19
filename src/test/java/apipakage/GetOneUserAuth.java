package apipakage;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetOneUserAuth {

	public static void main(String[] args) {

		System.out.println("Get Method");
		
		RestAssured.baseURI="https://gorest.co.in/public-api/users";
		
		given()
			.queryParam("access-token","XCmo61OIMh2o73B-goAGfET32Q5K5ZcO0gil")
//			.auth().basic("username","password")
			.body("")
		.when()
			.get()
		.then().log().all()
			.assertThat().statusCode(200)
			.header("Server", equalTo("nginx"))
			.body("result.id[0]", equalTo("1780"))
		;
		
		System.out.println("Get Method - Single User - PASS");
	}

}
