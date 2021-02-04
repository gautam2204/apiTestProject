package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GetCallsClass {

    @Given("An authorized user")
    public void an_authorized_user() {
    System.out.println("Test Given");
    }

    @When("want details of page {string}")
    public void want_details_of_page(String string) {
    System.out.println("Test When");
    }
}
