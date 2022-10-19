import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;

public class RestAssuredSpecs {
    public static RequestSpecification videoGamesRequestSpecification;
    public static ResponseSpecification videoGamesResponseSpecification;

    @BeforeMethod
    public void setRequestSpecification() {
        videoGamesRequestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/app/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    @BeforeMethod
    public void setResponseSpecification() {
        videoGamesResponseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }
}
