package com.Flyaway;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Flyaway_Capstone_API {

    String URL = "http://localhost:8080/FlyAway";

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = URL;
    }

    @Test(priority = 0)
    public void testLoginAction() {
        Response response = RestAssured.given()
            .queryParam("email_id", "user2@user1")
            .queryParam("pwd", "user1")
            .when()
            .post("/loginaction");
        response.then().statusCode(302);
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }

    @Test(priority = 1)
    public void login() {
        Response response = RestAssured.given()
            .when()
            .get("/login")
            .then()
            .statusCode(200)
            .extract()
            .response();
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }

    @Test(priority = 2)
    public void homepage() {
        Response response = RestAssured.given()
            .when()
            .get("/home")
            .then()
            .statusCode(200)
            .extract()
            .response();
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }

    @Test(priority = 3)
    public void BookFlight() {
        Response response = RestAssured.given()
            .when()
            .get("/bookflight?id=3")
            .then()
            .statusCode(200)
            .extract()
            .response();
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }

    @Test(priority = 4)
    public void completepurchase() {
        Response response = RestAssured.given()
            .when()
            .get("/completepurchase")
            .then()
            .statusCode(200)
            .extract()
            .response();
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }
}
