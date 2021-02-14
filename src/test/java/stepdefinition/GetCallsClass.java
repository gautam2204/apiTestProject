package stepdefinition;

import Enums.APIResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import pojo.UserDetails;
import utility.UtilityClass;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetCallsClass extends UtilityClass {


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

Headers headers= new Headers();
    @Given("I set a GET details service endpoint with header and {string}")
    public void iSetAGETDetailsServiceEndpointWithHeaderAnd(String resource,DataTable dataTable) throws JsonProcessingException {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.

      /*  List<Map<String,String>> mapList = dataTable.asMaps(String.class,String.class);
        System.out.println(mapList);


        mapList.forEach((Map<String, String> stringStringMap)-> {

                this.header = new Header(stringStringMap.get("key"),stringStringMap.get("value"));
            });*/
   // System.out.println("Header is \n"+header.toString());
        Map<String,String> map=dataTable.asMap(String.class,String.class);





        UserDetails response = given()
                .spec(requestSpecBuilder())
                .when()
                .get(APIResources.valueOf(resource).getResource())
                .then()
                .spec(responseSpecification())
                .extract()
                .response()
                .as(UserDetails.class);

    System.out.println(response.getData().get(1).getFirstName());

    }
}
