package JsonplaceholderCRUD;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class RemoveFirstAlbum extends BaseTest {
    @Test
    public void removeAlbum() {
        given()
                .when()
                .delete(BASE_URL + "/" + ALBUMS + "/1")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
