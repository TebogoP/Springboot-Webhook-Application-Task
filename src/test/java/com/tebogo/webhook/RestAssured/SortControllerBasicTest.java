package com.tebogo.webhook.RestAssured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SortControllerBasicTest{

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;

    }

    @Test
    public void testValidInputProvidedShouldReturn200(){
        RestAssured.given()
                .when()
                .then();
    }
}