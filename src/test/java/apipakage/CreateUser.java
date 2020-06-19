package apipakage;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.notNullValue;

public class CreateUser {

	public static void main(String[] args) {

		System.out.println("Api Testing");

		RestAssured.baseURI = "https://reqres.in/api/users";

		String userData = "{" + "\"name\" : \"deepak\", " + "\"job\" : \"leader\"" + "}";

		System.out.println("Post Data is : " + userData);

		given().body(userData).when().post().then().log().all().assertThat().statusCode(201)
//				.body ("id",  notNullValue())
		;

		System.out.println("Post Method - Single User - PASS");
	}

}
