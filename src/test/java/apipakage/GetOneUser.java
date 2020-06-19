package apipakage;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetOneUser {

	public static void main(String[] args) {

		System.out.println("Get Method");
		
		RestAssured.baseURI="http://reqres.in/api/users/2";
		
		given()
//			.queryParam("")
//			.body("")
		.when()
			.get()
		.then().log().all()
			.assertThat().statusCode(200)
			.body("data.first_name", equalTo("Janet"))
			.body("data.last_name", equalTo("Weaver"))
		;
		
		System.out.println("Get Method - Single User - PASS");
	}

}
