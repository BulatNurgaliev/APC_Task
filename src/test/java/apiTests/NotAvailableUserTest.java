package apiTests;

import baseTest.BasicTest;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constants.Constants.USERS_URL;
import static io.restassured.RestAssured.given;

public class NotAvailableUserTest extends BasicTest {

	@Test
	@DisplayName("Negative test using integer userId")
	public void getUserWithIntegerId() {
		Response response = given()
				.filter(new AllureRestAssured())
				.baseUri(USERS_URL)
				.basePath("/9999")
				.contentType(ContentType.JSON)
				.when().get()
				.then()
				.extract().response();
		Assertions.assertEquals(404, response.statusCode());
	}

	@Test
	@DisplayName("Negative test using string userId")
	public void getUserWithStringId() {
		Response response = given()
				.filter(new AllureRestAssured())
				.baseUri(USERS_URL)
				.basePath("/qwertyasdfg")
				.contentType(ContentType.JSON)
				.when().get()
				.then()
				.extract().response();
		Assertions.assertEquals(404, response.statusCode());
	}
}
