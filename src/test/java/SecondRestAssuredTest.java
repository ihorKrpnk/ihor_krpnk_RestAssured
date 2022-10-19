import videoGames.VideoGamesPostRequestPayload;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SecondRestAssuredTest extends RestAssuredSpecs {

    @Test
    public void secondRestAssuredTestWithPOGO() {

        VideoGamesPostRequestPayload videoGamesPostRequestPayload = new VideoGamesPostRequestPayload(
                0,
                "2022-10-19T10:58:01.289Z",
                "KarpTopGame",
                "bad",
                9889,
                "RPG");

        given()
                .spec(videoGamesRequestSpecification)
                .body(videoGamesPostRequestPayload)
                .when()
                .post("videogames")
                .then()
                .spec(videoGamesResponseSpecification)
                .log()
                .body();

    }
}
