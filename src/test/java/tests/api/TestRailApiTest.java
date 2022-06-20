package tests.api;


import configuration.Endpoints;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TestRailApiTest extends BaseAPITest {


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
    public void  updateProjectTest(){

        Project updateProjectByName = Project.builder()
                .name("АБЫРВАЛГ_Reborn")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", updateProjectByName.getName());

        given()
                .body(jsonAsMap)
                .when()
                .pathParams("project_id",72)
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);

    }


    @Test
    public void deleteProjectTest(){

        given()
                .when()
                .pathParams("project_id",72)
                .delete(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }


}
