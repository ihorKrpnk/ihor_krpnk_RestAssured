import videoGames.GameResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ThirdRestAssuredTestDeserialization extends RestAssuredSpecs {

    @Test
    public void getOneGameByIDUsingDeserialization() {

        Response response = given()
                .when()
                .spec(videoGamesRequestSpecification)
                .when()
                .get("videogames/9869");
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
