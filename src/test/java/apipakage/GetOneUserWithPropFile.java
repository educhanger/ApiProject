package apipakage;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetOneUserWithPropFile {

	public static void main(String[] args) {
		
		/* Following 5 lines are used to read property file
		 * ==================================================
		 * Properties prop = new Properties();
		 * File file = new File("resource/data.properties");
		 * FileInputStream fileInput = new FileInputStream(file);
		 * prop.load(fileInput);
		 * String myURL = prop.getProperty("url");
		 * ===================================================
		 */
				
		//Give the path of Properties file
		File file = new File("resource/data.properties");
		
		//Open file in reading mode
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Create an object of Properties file.
		Properties prop = new Properties();

		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Assign the URL value in myURL
	    String myURL = prop.getProperty("url");
	    
	    System.out.println(myURL);
		
	    RestAssured.baseURI=myURL+"/api/users/2";
		
		given()
			.queryParam("")
			.body("")
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
