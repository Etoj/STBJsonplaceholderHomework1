package JsonplaceholderCRUD;

import base.BaseTest;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetFirstAlbum extends BaseTest {

    @Test
    public void getFirstAlbum() {
        given()
                .when()
                .get(BASE_URL + "/" + ALBUMS + "/1")
                .then()
                .statusCode(200)
                .body("title", Matchers.equalTo("quidem molestiae enim"));
    }


}
