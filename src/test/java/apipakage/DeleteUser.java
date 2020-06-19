package apipakage;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.equalTo;

public class DeleteUser {

	public static void main(String[] args) {

		System.out.println("Delete Method");
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		given().
			queryParam("")
			.body("")
		.when()
			.delete()
		.then().log().all()
			.assertThat().statusCode(204)
			;
		
		System.out.println("Delete Method - Single User - PASS");
	}

}
