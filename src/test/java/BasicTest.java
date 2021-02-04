import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BasicTest {
  public static void main(String[] args) {
    RestAssured.baseURI="https://reqres.in";
    Response response = given().queryParam("page","2")
            .header("Content-Type","application/json")
            .when().get("/api/users").
            thenReturn();
    System.out.println("Response is = "+response.prettyPrint());

    JsonPath jsonPath = new JsonPath(response.asString());

  }
}
