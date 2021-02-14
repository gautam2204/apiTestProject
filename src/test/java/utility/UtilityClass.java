package utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UtilityClass {

    public static RequestSpecification requestSpecBuilder()
    {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setContentType(ContentType.JSON)
                .build();

    }

    public ResponseSpecification responseSpecification()
    {
       return new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

    }
}
