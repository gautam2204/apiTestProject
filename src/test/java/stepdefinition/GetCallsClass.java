package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import static io.restassured.RestAssured.given;

public class GetCallsClass {

    @Given("An authorized user")
    public void an_authorized_user() {
        RestAssured.baseURI = "https://reqres.in/";

    }

    @When("want details of page {string}")
    public void want_details_of_page(String string) {
    System.out.println("Test When");
    }
}
