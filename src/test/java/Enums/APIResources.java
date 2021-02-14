package Enums;

public enum APIResources {

    GETUser("/api/users?page=2");

   private final String resource;


    APIResources(String resource) {
        this.resource = resource;

    }

    public String getResource() {
        return resource;
    }
}
