package stepdefinition;

import Enums.APIResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojo.User;
import utility.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static io.restassured.RestAssured.given;

public class GetCallsClass extends UtilityClass {

  private Response response;
  Headers headers = new Headers();
  User user;

  @Then("I recieve a {int}")
  public void i_recieve_a(int code) {
    Assert.assertEquals(code, response.getStatusCode());
  }

  @Given("^I set a \"([^\"]*)\" details service endpoint with header$")
  public void iSetAGETDetailsServiceEndpointWithHeaderAnd(String request, DataTable dataTable)
      throws JsonProcessingException {
    /*  List<Map<String,String>> mapList = dataTable.asMaps(String.class,String.class);
    System.out.println(mapList);


    mapList.forEach((Map<String, String> stringStringMap)-> {

            this.header = new Header(stringStringMap.get("key"),stringStringMap.get("value"));
        });*/
    // System.out.println("Header is \n"+header.toString());
    System.out.println(request);
    List<Header> headerList = new ArrayList<Header>();
    Map<String, String> map = dataTable.asMap(String.class, String.class);
    for (Map.Entry<String, String> entry : map.entrySet()) {
      String k = entry.getKey();
      String v = entry.getValue();
      headerList.add(new Header(k, v));
      headers = new Headers(headerList);
    }

    System.out.println("headers Below \n" + headers);

    // System.out.println(response.getData().get(1).getFirstName());

  }

  @When("I send a GET request to the server {string}")
  public void iSendAGETRequestToTheServer(String resource) {
    response =
        given()
            .spec(requestSpecBuilder())
            .when()
            .queryParam("page", 2)
            .headers(headers)
            .get(APIResources.valueOf(resource).getResource())
            .then()
            .spec(responseSpecification())
            .extract()
            .response();
  }

  @Then("validate body for the request")
  public void validate_body_for_the_request(DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.

    Map<String, String> map = dataTable.asMap(String.class, String.class);

    for (Map.Entry<String, String> map1 : map.entrySet()) {
      JsonPath jsonPath = new JsonPath(response.asString());
      String k = jsonPath.get(map1.getKey());
      String v = map1.getValue();
      Assert.assertEquals(k, v);
    }

    /* List<Map<String,Object>> mapList = dataTable.asMaps(String.class,Object.class);
    mapList.forEach(new Consumer<Map<String, Object>>() {
      @Override
      public void accept(Map<String, Object> stringObjectMap) {
        */
    /*JsonPath jsonPath = new JsonPath(response.asString());
    String k = jsonPath.get(stringObjectMap.get("key").toString());
    String v = stringObjectMap.get("value").toString();
    Assert.assertEquals(k,v);*/
    /*
      }
    });*/

  }

  @When("I send a POST request to {string} with {string} body")
  public void i_send_a_POST_request_to_with_body(String resource, String UserDetails)
      throws JsonProcessingException {
    User user = createUser();
    /*ObjectMapper objectMapper= new ObjectMapper();
    String jsonFormatString = objectMapper.writeValueAsString(user);*/
    response =
        given()
            .spec(requestSpecBuilder())
            .when()
            .headers(headers)
            .body(user)
            .post(APIResources.valueOf(resource).getResource())
            .then()
            .spec(responseSpecification())
            .extract()
            .response();
  }

  private User createUser() {
    return User.builder().job("leader").name("morpheus").build();
  }

  @Given("^I log in as an (.*) to the site$")
  public void iLogInAsAnAdmin(String str) {
    System.out.println(str);
  }

  @Given("^I work as (Engineer|Labour) in the (.*) company")
  public void iWorkAsEngineerInTheSoftwareCompany(String str, String str1) {
    System.out.println(str + "  --- " + str1);
  }

  @Given("^I will test positive scenario(?: as well as \"([^\"]*)\")?$")
  public void iWillTestPositiveScenarioAsWellAs(String scenario) {
    String scenarioName = scenario == null ? "No Value" : "Have Value";
    System.out.println(scenarioName);
  }

  @When("I send a GET request to the covid server {string}")
  public void iSendAGETRequestToTheCovidServer(String resource) {
    RequestSpecification requestSpecification =
        given()
            .baseUri("https://cdn-api.co-vin.in/api")
            .when()
            .queryParam("pincode", "248001")
            .queryParam("date", "18-05-2021")
            .headers(headers);
    response = requestSpecification.get(APIResources.valueOf(resource).getResource());

    response.prettyPrint();

  }
}
