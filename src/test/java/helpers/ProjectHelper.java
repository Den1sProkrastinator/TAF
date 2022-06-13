package helpers;

import com.google.gson.Gson;
import configuration.Endpoints;
import io.restassured.response.Response;
import models.Project;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ProjectHelper {

    public Project getProject(int project_id) {

        return given()
                .pathParams("project_id", project_id)
                .get(Endpoints.GET_PROJECT)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(Project.class);

    }


    public Response getProjectResponse(int project_id) {

        return given()
                .pathParams("project_id", project_id)
                .get(Endpoints.GET_PROJECT);

    }

    public Project[] getAllProject(){
        Response response= given()

                .get(Endpoints.GET_PROJECT);
       return new Gson().fromJson(response.getBody().jsonPath().getString("projects"),Project[].class);
    }

}
