package tests.api;


import configuration.Endpoints;
import configuration.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;

import static io.restassured.RestAssured.given;

public class TestRailApiTest extends BaseApitTest{

@Test
    public void getAllUserTest(){
    // Setup request Object
    RequestSpecification httpRequest = given();
    httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);
    httpRequest.auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

    // Setup Response Object
    URI endpoint;
    Response response = httpRequest.request(Method.GET, Endpoints.GET_PROJECTS);

    // Get Response Status
    int statusCode = response.getStatusCode();
    System.out.println("Status Code: " + statusCode);
    Assert.assertEquals(statusCode, HttpStatus.SC_OK);

    // Get Response Body
    String responseBody = response.getBody().asString();
    System.out.println("Response: " + responseBody);
}

@Test
    public void test (){
    given()
//            .header(HTTP.CONTENT_TYPE,ContentType.JSON)
//            .auth().preemptive().basic(ReadProperties.username(),ReadProperties.password())
            .when()
            .get(Endpoints.GET_PROJECTS)
            .then()
            .log().status()
            .log().body()
            .statusCode(HttpStatus.SC_OK);
}
}
