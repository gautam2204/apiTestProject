package thisIsTestLearning.TestPackage;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SpecBuilder {

    @Test
    public void createJsonwithLombokBuilder()
    {

        RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://reqres.in").setContentType(ContentType.JSON).build();
        ResponseSpecification responseSpecBuilder = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(201).build();

        Response response = given()
               .spec(requestSpecBuilder)
               .body("{\n" +
                       "    \"name\": \"morpheus\",\n" +
                       "    \"job\": \"leader\"\n" +
                       "}")
               .when()
               .post("/api/users")
               .then().spec(responseSpecBuilder).extract().response();
    System.out.println("Response \n"+response.prettyPrint());


    }
}
