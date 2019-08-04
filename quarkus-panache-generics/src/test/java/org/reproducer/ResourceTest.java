package org.reproducer;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;
import org.reproducer.model.TheEntity;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ResourceTest {

    @Test
    public void testHelloEndpoint() {
        TheEntity theEntity = new TheEntity();
        theEntity.cl = "This is a column value";
        Jsonb jsonb = JsonbBuilder.create();
        String autorJson = jsonb.toJson(theEntity);
        given()
            .when().get("/entity")
            .then()
                .statusCode(200)
                .body(equalTo("[]"));  
        given()
            .when().get("/entity/1")
            .then()
                .statusCode(404);                 
        given()
            .when()
                .contentType("application/json")
                .body(autorJson).post("/entity")
            .then()
                .statusCode(201).body(equalTo(""));
        given()
            .when().get("/entity")
            .then()
                .statusCode(200)
                .body(containsString(theEntity.cl));  
        given()
            .when().get("/entity/1")
            .then()
                .statusCode(200)
                .body(containsString(theEntity.cl));                 
        given()
            .when().delete("/entity/1")
            .then()
                .statusCode(204)
                .body(equalTo("")); 
        given()
            .when().get("/entity")
            .then()
                .statusCode(200)
                .body(equalTo("[]")); 
    }

}