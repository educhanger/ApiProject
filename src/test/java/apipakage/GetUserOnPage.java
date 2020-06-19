package apipakage;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetUserOnPage {

	public static void main(String[] args) {

		System.out.println("Api Testing");
		
		RestAssured.baseURI="http://reqres.in/api/users";
		given().
			queryParam("page","1")
			.body("")
		.when()
			.get()
		.then().log().all()
			.assertThat().statusCode(200)
			.body("page", equalTo(1))
			.body("data.first_name[0]", equalTo("George"))
			;
		
		System.out.println("Get Users on Page - PASS");
	}

}
