    package com.tebogo.webhook.RestAssured;

    import com.tebogo.webhook.exception.InvalidInputException;
    import io.restassured.RestAssured;
    import io.restassured.http.ContentType;    
    import io.restassured.specification.RequestSpecification;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;
    import static org.hamcrest.Matchers.*;

    import java.util.HashMap;
    import java.util.Map;

    public class SortControllerBasicTest{

        @BeforeAll
        static void setup() {
            RestAssured.baseURI = "http://localhost";
            RestAssured.port = 8080;
        }
        public RequestSpecification request(){
            return RestAssured.given();
        }

        @Test
        public void testValidInputProvidedShouldReturn200() throws NullPointerException {

            Map<String, String> basicPayload = new HashMap<>();
            basicPayload.put("data", "abc");
            String jsonPayload = "{" +
                    "\"data\":\"abc\"" +
                    "}";
            try {
                request()
//                        .header("content-Type","application/json")
//                    .contentType("application/json")
                        .contentType(ContentType.JSON)
                        .body(jsonPayload)
                        .when()
                        .post("/api/sort")
                        .then()
                        .statusCode(200)
                        .body("word", contains("a", "b", "c"))
                        .log().all();
            } catch (NullPointerException e) {
                e.printStackTrace();

            }
        }
    }