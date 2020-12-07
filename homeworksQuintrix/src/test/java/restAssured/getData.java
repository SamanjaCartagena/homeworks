package restAssured;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import restAssuredUsers.Users;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class getData {
	private static final String JSON = "application/json";
	String baseUrl = "https://reqres.in/api";
	String endpoint = "http://dummy.restapiexample.com/api/v1/employees";
	//Works properly
	@Test
	public void testResponsecode() {
		
		Response response = get("https://reqres.in/api/users/2");
        System.out.println(response.asString());
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
        
        System.out.println("=======================================");
        
        
	}
	
	//Number 1
	@Test
	void test_02() {
		given().get("https://reqres.in/api/users/2")
		.then().statusCode(200)
		.body("data.email", equalTo("janet.weaver@reqres.in"));
	}
	//Works properly
	@Test
	void post_login_successful() {
		Response response = get("https://reqres.in/api/login");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
       
		
	}
	//Works properly
	//Number2
	@Test
	public void verifyEmailAddress() {

		String endpoint = getEndpoint("/users/2");
		String email = "janet.weaver@reqres.in";
		given().
         when()
		.get(endpoint)
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("data.email", equalTo(email));
	}


	@Test
	public void returnValue() {
		String endpoint = getEndpoint("/login");
		String token = "QpwL5tke4Pnpja7X4";

		JsonObject loginCredentials = new JsonObject();
		loginCredentials.addProperty("email", "eve.holt@reqres.in");
		loginCredentials.addProperty("password", "cityslicka");

		given()
		.contentType(JSON)
		.body(loginCredentials.toString())
		.post(endpoint)
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("token", is(token));
	}

	
	//Works properly
	@Test
	public void verifyDelete() {

		String endpoint = getEndpoint("/users/2");

		given()
		.delete(endpoint)
		.then()
		.assertThat()
		.statusCode(204);
	}
	
	@Test
	public void canPatch() {

		String endpoint = getEndpoint("/users/2");

		Users user = new Users();
		user.name = "morpheus2";
		user.job = "zion resident";

		given()
		.contentType(JSON)
		.body(user)
		.patch(endpoint)
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("name", is(user.name))
		.body("job", is(user.job));
	}
	@Test
	public void canPut() {

		String endpoint = getEndpoint("/users/2");

		Users user = new Users();
		user.name = "morpheus2";
		user.job = "zion resident";

		given()
		.contentType(JSON)
		.body(user)
		.put(endpoint)
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("name", is(user.name))
		.body("job", is(user.job));

	}

	
	//Number4 Works properly
	@Test
	
void updateUsingPatch() {
		
		int emptID=15051;
		RestAssured.baseURI ="https://reqres.in/api/users/2";
		 RequestSpecification request = RestAssured.given();
		 // Add a header stating the Request body is a JSON
		 request.header("Content-Type", "application/json"); 
		// JSONObject requestParams = new JSONObject();
		 request.put("name", "Morpheus2"); // Cast
		 request.put("job", "zion resident");
		 
		 Response response = request.patch("/update/"+emptID);
		 
		 int statusCode = response.getStatusCode();
		
		 System.out.println(response.asString());
         System.out.println("The body is "+response.getBody());
		// System.out.println(response.getTime());
		 Assert.assertEquals(statusCode, 200); 
	
		 
	}
	@Test
	public void canDeserializeSingleUser() {

		String endpoint = getEndpoint("/users/2");

		Users details = new Users();
		details.id = 2;
		details.email = "janet.weaver@reqres.in";
		details.first_name = "Janet";
		details.last_name = "Weaver";
		details.avatar = "https://reqres.in/img/faces/2-image.jpg";
		
		Users expectedDetails = new Users();
		expectedDetails.url = "https://reqres.in/#support-heading";
		expectedDetails.text = "To keep ReqRes free, contributions towards server costs are appreciated!";
		
		Users expectedUserDetails = new Users();
		expectedUserDetails.data = details;
		expectedUserDetails.support = expectedDetails;
		
		Users updatedUser = given()
		.get(endpoint)
		.getBody()
		.as(Users.class);

		Assert.assertEquals(updatedUser.getData().id, expectedUserDetails.getData().id);
		Assert.assertEquals(updatedUser.getData().email, expectedUserDetails.getData().email);
		Assert.assertEquals(updatedUser.getData().first_name, expectedUserDetails.getData().first_name);
		Assert.assertEquals(updatedUser.getData().last_name, expectedUserDetails.getData().last_name);
		Assert.assertEquals(updatedUser.getData().avatar, expectedUserDetails.getData().avatar);

		Assert.assertEquals(updatedUser.getSupport().url, expectedUserDetails.getSupport().url);
		Assert.assertEquals(updatedUser.getSupport().text, expectedUserDetails.getSupport().text);
	}

	
 

	
	/**
	@Test
	void listUsers() {
	//Number6 Works properly
	RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("");
	 
	 // First get the JsonPath object instance from the Response interface
	 JsonPath jsonPathEvaluator = response.jsonPath();
	 
	 
	List<String> allUsers = jsonPathEvaluator.getList("data.email");
	 
	 // Iterate over the list and print individual book item
	 for(String emails : allUsers)
	 {
	 System.out.println("Emails: " + emails);
	 }
	 
	 System.out.println("Now store all details in List class");
	 

	 List<ListUsers> allUsers2 = jsonPathEvaluator.getList("data", ListUsers.class);
     
		// Iterate over the list and print individual book item
		// Note that every book entry in the list will be complete Json object of book
		for(ListUsers userInfo : allUsers2)
		{
			System.out.println("Avatar: " + userInfo.avatar);
		}
	**/
	 
private String getEndpoint(String endpoint) {
	return baseUrl + endpoint;
}
}


