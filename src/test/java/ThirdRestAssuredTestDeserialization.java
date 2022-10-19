import videoGames.GameResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ThirdRestAssuredTestDeserialization extends RestAssuredSpecs {

    @Test
    public void thirdRestAssuredTestDeserialization() {

        Response response = given()
                .when()
                .spec(videoGamesRequestSpecification)
                .when()
                .get("videogames/2230");
        response
                .then()
                .log()
                .body();

        GameResponse gameResponse = response.as(GameResponse.class);
        String nameGame = gameResponse.getName();
        String nameCategory = gameResponse.getCategory();
        String nameRating = gameResponse.getRating();

        System.out.println(nameGame);
        System.out.println(nameCategory);
        System.out.println(nameRating);
    }
}
