package thisIsTestLearning.TestPackage;

import NewPojoSchema.Datum;
import NewPojoSchema.Support;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import thisIsTestLearning.NewPojoSchema.User;

import java.util.ArrayList;
import java.util.List;

public class SerializationDeserialzation {
  @Test
  public void SerializeWithObjectMapperTest() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    User user = setUserDataSerialization();

    /*
      Serialization means converting java object to string
     */
    String str = objectMapper.writeValueAsString(user);
    System.out.println("Json is \n"+str);
  }

  private User setUserDataSerialization() {

    return new User()
        .withPage(2)
        .withTotal(1)
        .withPerPage(2)
        .withTotalPages(3)
        .withData(gteDatumList())
        .withSupport(new Support().withText("this is support Text").withUrl("thisIsUrl"));
  }

  private List<NewPojoSchema.Datum> gteDatumList() {
    Datum datum =
        new Datum()
            .withAvatar("this is avatar")
            .withId(1)
            .withFirstName("gautam")
            .withLastName("rawat");
    ArrayList<Datum> arrayList = new ArrayList<>();
    arrayList.add(datum);
    return arrayList;
  }


  @Test
  public void De_SerializeWithObjectMapperTest() throws JsonProcessingException {
    /*
    Deserialization means converting string to java object
     */
    String jsonString =
        "{\"page\":2,\"per_page\":2,\"total\":1,\"total_pages\":3,\"data\":[{\"id\":1,\"first_name\":\"gautam\",\"last_name\":\"rawat\",\"avatar\":\"this is avatar\"}],\"support\":{\"url\":\"thisIsUrl\",\"text\":\"this is support Text\"}}\n";
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.readValue(jsonString,User.class);
    System.out.println(User.class);

}
}
