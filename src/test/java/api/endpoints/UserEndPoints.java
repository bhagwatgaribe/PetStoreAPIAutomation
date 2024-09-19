package api.endpoints;

import api.payload.User;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.post_url);
		return response;
	}

	public static Response readUser(String userName) {

		Response response = given()
			.pathParams("username", userName)
		.when()
			.post(Routes.get_url);
		return response;
	}
	
	public static Response updateUser(String userName, User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParams("username", userName)
			.when()
				.post(Routes.update_url);
		return response;
	}
	
	public static Response deleteUser(String userName) {

		Response response = given()
			.pathParams("username", userName)
		.when()
			.post(Routes.delete_url);
		return response;
	}
}
