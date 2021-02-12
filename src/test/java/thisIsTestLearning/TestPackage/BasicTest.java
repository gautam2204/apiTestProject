package thisIsTestLearning.TestPackage;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BasicTest {
SessionFilter sessionFilter = new SessionFilter();
  public static void main(String[] args) {
    RestAssured.baseURI="https://reqres.in";
    Response response =
        given()
            .queryParam("page", "2")
            .header("Content-Type", "application/json")
            .when()
            .get("/api/users")
            .then()
            .extract()
            .response();
    System.out.println("Session = "+response.getSessionId());
    System.out.println("Response is = "+response.prettyPrint());



    getListOfNames(response);

  }

  private static void getListOfNames(Response response) {
JsonPath jsonPath = new JsonPath(response.asString());
    int count = jsonPath.get("data.size()");
System.out.println(
        "count is "+count
);
for(int i=0;i<count;i++)
{
      System.out.println("Value at " + i + " is " + jsonPath.getString("data["+i+"].first_name"));
}

  }
}
