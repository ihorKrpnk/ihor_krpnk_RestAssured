import io.restassured.response.Response;
import org.testng.annotations.Test;
import users.UsersItem;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class FifthRestAssuredTest {

    @Test
    public void getCollection() {
        Response response = given()
                .when()
                .get("http://jsonplaceholder.typicode.com/users");

        UsersItem[] usersItems = response.as(UsersItem[].class);
        Arrays.stream(usersItems).forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        List<UsersItem> firstUserItems = Arrays.asList(response.as(UsersItem[].class));

        int firstUsersID = firstUserItems.get(0).getId();
        String firstUsersIDName = firstUserItems.get(0).getName();
        String firstUsersIDCity = firstUserItems.get(0).getAddress().getCity();
        String firstUsersIDStreet = firstUserItems.get(0).getAddress().getStreet();

        System.out.println
                ("first User's ID: " + firstUsersID + "\n"
                        + "first User's ID name: " + firstUsersIDName + "\n"
                        + "first User's ID city: " + firstUsersIDCity + "\n"
                        + "first User's ID street: " + firstUsersIDStreet);

    }
}
