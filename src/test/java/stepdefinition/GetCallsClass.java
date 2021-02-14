package stepdefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Datum;
import pojo.UserDetails;

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

    @When("I send a GET request to the server")
    public void i_send_a_GET_request_to_the_server() {
    }
    @Then("I recieve a {string}")
    public void i_recieve_a(String string) {
    }
    @Then("body for the request")
    public void body_for_the_request() {
    }


    @Given("I set a GET details service endpoint with header and {string}")
    public void iSetAGETDetailsServiceEndpointWithHeaderAnd(String arg0,DataTable dataTable) throws JsonProcessingException {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.

        RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://reqres.in").setContentType(ContentType.JSON).build();
        ResponseSpecification responseSpecBuilder = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();

        UserDetails response = given()
                .spec(requestSpecBuilder)
                .when()
                .get("/api/users?page=2")
                .then().spec(responseSpecBuilder).extract().response().as(UserDetails.class);

    System.out.println(response.getData().get(1).getFirstName());

    }
}
