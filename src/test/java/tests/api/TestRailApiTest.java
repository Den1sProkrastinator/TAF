package tests.api;


import com.google.gson.Gson;
import configuration.Endpoints;
import configuration.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestRailApiTest extends BaseApitTest {

    @Test
    public void getAllUserTest() {
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
    public void getAPIShortTest() {
        given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectTest() {
        Project newProject = Project.builder()
                .name("WP_Test_01")
                .build();

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\"\n" +
                        "}", newProject.getName()))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject2() {
        Project project = Project.builder()
                .name("WP_Project_02")
                .typeOfProject(ProjectType.SINGLE_SUITE_MODE)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3() {
        Project project = Project.builder()
                .name("WP_Test_03")
                .typeOfProject(ProjectType.MULTIPLE_SUITE_MODE)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        Project newProject = given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);

        System.out.println(newProject.toString());
    }

    @Test
    public void validateObjectTestTest() {
        given()

                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .body("projects.get(0).id",is(1))
                .body("projects.get(0).name",equalTo("Denis_QA18_PO_HW"));


    }

    @Test
    public void validateNameObjectTestTestwithJSonPath() {
       JsonPath jsonPath= given()

                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
               .extract()
               .jsonPath();

       String name= jsonPath.getString("projects[0].name");
       int id  = jsonPath.getInt("projects[0].id");
        System.out.println(name);
        Assert.assertEquals(name,"Denis_QA18_PO_HW");



    }


    @Test
    public void getExactProject(){
        given()
                .pathParams("project_id",1)
                .get(Endpoints.GET_PROJECT)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id",is(1))
                .body("name",equalTo("Denis_QA18_PO_HW"));
    }
    @Test
    public void getExactProjectAsObjectsTest(){
       Response response= given()
                .pathParams("project_id",1)
                .get(Endpoints.GET_PROJECT);

       Project actualProject = new Gson().fromJson(response.getBody().asString(),Project.class);

       Assert.assertEquals(actualProject.getName(),"Denis_QA18_PO_HW");
    }


}
