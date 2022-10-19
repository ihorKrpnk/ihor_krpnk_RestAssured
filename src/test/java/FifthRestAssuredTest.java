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

        List<UsersItem> usersItems = Arrays.asList(response.as(UsersItem[].class));

        int firstUsersID = usersItems.get(0).getId();
        String firstUsersIDName = usersItems.get(0).getName();
        String firstUsersIDCity = usersItems.get(0).getAddress().getCity();
        String firstUsersIDStreet = usersItems.get(0).getAddress().getStreet();

        System.out.println(firstUsersID);
        System.out.println(firstUsersIDName);
        System.out.println(firstUsersIDCity);
        System.out.println(firstUsersIDStreet);
    }
}
