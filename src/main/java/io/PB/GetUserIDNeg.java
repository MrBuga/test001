package io.PB;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
public class GetUserIDNeg {
    @Test()
    public void UserIDNEgGet() {
        RestAssured.given()
                .baseUri("http://localhost:8080")
                .pathParam("id",  "-3")
                .when()
                .log().uri()
                .get("/users/{id}")
                .then().log().all().body("error", Matchers.equalTo("User with this id: -3 not found"))
                .assertThat()
                .statusCode(404);
    }
}
