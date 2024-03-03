package com.Flyaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Flyaway_Capstone_API {
	Response response;
	RestAssured restAssured;
	String URL = "http://localhost:8080/FlyAway";
	private static final Logger logger = LogManager.getLogger(Flyaway_Capstone_API.class);

	@Before
	public void setup() {
		RestAssured.baseURI = URL;

	}

	@Test
	public void loginaction() {
		logger.info("loginaction");
		Response response = (Response) RestAssured.given().when().post("/loginaction?email_id=user2@user1&pwd=user1")
				.then().statusCode(200).extract();
		System.out.println(response.getStatusCode());
		System.out.println(response.body().asString());

	}

	@Test
	public void login() {
		logger.info("login");
		Response response = (Response) RestAssured.given().when().get("/login").then().statusCode(200).extract();
		System.out.println(response.statusCode());
		System.out.println(response.body().asString());

	}

	@Test
	public void homepage() {
		Response response = (Response) RestAssured.given().when().get("/home").then().statusCode(200).extract();
		System.out.println(response.statusCode());
		System.out.println(response.body().asString());
	}

	@Test
	public void SearchFlight() {
		Response response = (Response) RestAssured.given().when().get("/home?source=1&destination=4").then()
				.statusCode(200).extract();
		System.out.println(response.statusCode());
		System.out.println(response.body().asString());
	}

	@Test
	public void BookFlight() {
		Response response = (Response) RestAssured.given().when().get("/bookflight?id=3").then().statusCode(200)
				.extract();
		System.out.println(response.statusCode());
		System.out.println(response.body().asString());
	}

	@Test
	public void completepurchase() {
		Response response = (Response) RestAssured.given().when().get("/completepurchase").then().statusCode(200)
				.extract();
		System.out.println(response.statusCode());
		System.out.println(response.body().asString());
	}
}
