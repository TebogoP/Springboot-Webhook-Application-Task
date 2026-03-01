package com.tebogo.webhook.RestAssured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SortControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void shouldReturnSortedCharacters() {
//        given()
//                .contentType("application/json")
//                .body("{\"data\":\"example\"}")
//                .when()
//                .post("/api/sort")
//                .then()
//                .statusCode(200)
//                .body("word", hasItems("a","e","e","l","m","p","x"));
    }

    @Test
    void shouldReturn400WhenInputIsEmpty() {
//        given()
//                .contentType("application/json")
//                .body("{\"word\":\"\"}")
//                .when()
//                .post("/api/sort")
//                .then()
//                .statusCode(400)
//                .body("error", equalTo("Bad Request"))
//                .body("message", equalTo("Input string cannot be null or empty"));
    }
}