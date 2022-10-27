import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FirstRestAssuredTest extends RestAssuredSpecs {

    @Test
    public void getAllGamesResponseTimeCheck() {

        Response response = given()
                .spec(videoGamesRequestSpecification)
                .when()
                .get("videogames");

        long responseTime = response.getTime();
        System.out.println("GameResponse time in ms:" + responseTime);

        response.then()
                .spec(videoGamesResponseSpecification)
                .time(Matchers.lessThan(2000L))// Asserting response time is less than 2000 milliseconds (L just represent long. It is in millisecond by default.)
                .log()
                .all();
    }
}
