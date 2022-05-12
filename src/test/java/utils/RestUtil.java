package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtil {
    //Utility class to store all the Rest Assured properties and methods as one place
    public String baseURI = ConfigReader.getConfigReader().getBaseURI();
    public RequestSpecification requestSpecification;
    public Response response;

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public Response getResponse() {
        return response;
    }
    public RestUtil(){
        requestSpecification = RestAssured.given();
    }

}
