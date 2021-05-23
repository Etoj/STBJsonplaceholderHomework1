package JsonplaceholderUsers;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckMailFromPLNotExist extends BaseTest {

    @Test
    public void checkMailFromPLNotExist() {
        Response response = given()
                .when()
                .get(BASE_URL + "/"+USERS)
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        List<String> emails = json.getList("email");
        boolean pl = emails.stream()
                .anyMatch(email -> email.endsWith("pl"));

        assertEquals(false, pl);


    }
}

