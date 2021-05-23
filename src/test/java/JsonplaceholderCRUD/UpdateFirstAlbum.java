package JsonplaceholderCRUD;

import base.BaseTest;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateFirstAlbum extends BaseTest {

    @BeforeAll
    public static void beforeAll() {
        faker = new Faker();
    }

    @BeforeEach
    public void beforeEach() {
        fakeUserId = faker.number().numberBetween(1, 10);
        fakeTitle = faker.dragonBall().character();
    }

    @Test
    public void updateFirstAlbumPUT() {
        JSONObject post = new JSONObject();
        post.put("userId", fakeUserId);
        post.put("title", fakeTitle);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(post.toString())
                .when()
                .put(BASE_URL + "/" + ALBUMS + "/1")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        Assertions.assertEquals(fakeTitle, json.get("title"));
        Assertions.assertEquals(fakeUserId, json.getInt("userId"));

    }

    @Test
    public void updateFirstAlbumPATH() {
        JSONObject post = new JSONObject();
        post.put("userId", fakeUserId);
        post.put("title", fakeTitle);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(post.toString())
                .when()
                .patch(BASE_URL + "/" + ALBUMS + "/1")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        Assertions.assertEquals(fakeTitle, json.get("title"));
    }
}
