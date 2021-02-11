package thisIsTestLearning;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import thisIsTestLearning.model.Data;
import thisIsTestLearning.model.GetUser;
import thisIsTestLearning.model.Support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class PostCheck {

  @Test
  public void case1() {
    RegisterPojo registerPojo = new RegisterPojo();
    registerPojo.setEmail("eve.holt@reqres.in");
    registerPojo.setPassword("pistol");

    RestAssured.baseURI = "https://reqres.in";
    Response response =
        given()
            .header("Content-Type", "application/json")
            .body(registerPojo)
            .when()
            .post("/api/register")
            .then()
            .extract()
            .response();
    System.out.println("Response is = " + response.prettyPrint());
  }

  @Test
  public  void Test2()
  {
    Data data =new Data();
    data.setEmail("tobias.funke@reqres.in");
    data.setAvatar("https://reqres.in/img/faces/9-image.jpg");
    data.setId(9);
    data.setFirst_name("tobias");
    data.setLast_name("funke");
    Data data2 =new Data();
    data2.setEmail("tobias.funke@reqres.in");
    data2.setAvatar("https://reqres.in/img/faces/9-image.jpg");
    data2.setId(9);
    data2.setFirst_name("tobias");
    data2.setLast_name("funke");

    List<Data> dataList = new ArrayList<>();
    dataList.add(data);
    dataList.add(data2);

    Support support = new Support();
    support.setUrl("https://reqres.in/#support-heading");
    support.setText("To keep ReqRes free, contributions towards server costs are appreciated!");

    GetUser getUser = new GetUser();
    getUser.setPage("2");
    getUser.setPer_page("6");
    getUser.setTotal("12");
    getUser.setTotal_pages("2");
    getUser.setSupport(support);
    getUser.setData(dataList);

    System.out.println("Print JavaObject \n"+getUser);
    System.out.println("Print JSON");
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      String jsonObj = objectMapper.writeValueAsString(getUser);
      System.out.println(jsonObj);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    RestAssured.baseURI = "https://reqres.in";
    GetUser getUserResponse =
            given()
                    .header("Content-Type", "application/json")
                    .queryParam("page","2")
                    .when()
                    .get("/api/users")
                    .then()
                    .extract().as(GetUser.class);

    System.out.println(
            getUserResponse.getData().get(2).getFirst_name());

  }
}
