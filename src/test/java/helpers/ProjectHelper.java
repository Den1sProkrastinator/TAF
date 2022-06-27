package helpers;

import configuration.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectHelper {

    List<Project> projectList = new ArrayList<>();

    public Project getProject(int project_id) {
        return given()
                .pathParam("project_id", project_id)
                .get(Endpoints.GET_PROJECT)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);
    }

    public Response getProjectResponse(int project_id) {
        return given()
                .pathParam("project_id", project_id)
                .get(Endpoints.GET_PROJECT);
    }

    public List<Project> getAllProjects() {
        Response response = given()
                .get(Endpoints.GET_PROJECTS);

        return response.getBody().jsonPath().getList("projects", Project.class);
    }

    public Response getAllProjectsResponse() {
        return null;
    }

    public Project addProject(Map jsonMap){



     return   given()
                .body(jsonMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);

    }

    public int getProjectID(Project  project){
        JsonPath jsonPath= given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .extract()
                .jsonPath();
        int id  = jsonPath.getInt("projects[0].id");
        return  id;

    }

    @Test
    public void  updateProject(){

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

}
