package Enums;

public enum APIResources {

    GETUser("/api/users"),
    POSTUser("/api/users"),
    GETCOVIDSLOT("/v2/appointment/sessions/public/findByPin");

   private final String resource;


    APIResources(String resource) {
        this.resource = resource;

    }

    public String getResource() {
        return resource;
    }
}
