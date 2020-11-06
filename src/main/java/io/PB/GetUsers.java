package io.PB;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
public class GetUsers {
    @Test()
    public void UsersGet() {
        RestAssured.given()
                .baseUri("http://localhost:8080")
                .when()
                .log().uri()
                .get("/users")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
