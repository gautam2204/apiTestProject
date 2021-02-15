package headerConfig;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class GetHeaderClass implements HeaderConfiguration{
    @Override
    public Headers setHeaders() {
        Header header = new Header("Content-Type","application/json");
        return new Headers(header);
    }
}
