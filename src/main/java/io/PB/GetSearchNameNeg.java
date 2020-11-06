package io.PB;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
public class GetSearchNameNeg {
    @Test()
    public void UsersSearchNegGet() {
        RestAssured.given()
                .baseUri("http://localhost:8080")
                .pathParam("Name",  "Vladimir")
                .when()
                .log().uri()
                .get("/users/search?name={Name}")
                .then().log().all().body("error", Matchers.equalTo("Users with this name: Vladimir is not present"))
                .assertThat()
                .statusCode(404);

    }
}
