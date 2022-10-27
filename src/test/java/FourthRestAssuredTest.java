import videoGames.VideoGamesPostRequestPayload;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FourthRestAssuredTest extends RestAssuredSpecs {

    @Test
    public void nameCategoryGameUpdate() {

        VideoGamesPostRequestPayload videoGamesPostRequestPayload = new VideoGamesPostRequestPayload(
                0,
                "2022-10-19T10:58:01.289Z",
                "KarpTopGame22",
                "not bad",
                9869,
                "Shooter");

        given()
                .spec(videoGamesRequestSpecification)
                .body(videoGamesPostRequestPayload)
                .when()
                .put("videogames/9889")
                .then()
                .spec(videoGamesResponseSpecification)
                .log()
                .body();

    }
}
