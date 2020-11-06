package io.PB;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
public class GetContacts {
    @Test()
    public void ContactGet(){
        RestAssured.given()
                .baseUri("http://localhost:8080")
                .pathParam("id",  "1")
                .when()
                .log().uri()
                .get("/users/{id}/contacts")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
