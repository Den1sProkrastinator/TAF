package helpers;

import configuration.Endpoints;
import io.restassured.response.Response;
import models.Milestone;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestoneHelper {

    public Milestone getMilestone(int milestoneID) {
        return given()
                .pathParams("milestone_id", milestoneID)
                .get(Endpoints.GET_MILESTONE)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class);
    }

    public Milestone getMilestones(int projectID) {
        return given()
                .pathParams("project_id", projectID)
                .get(Endpoints.GET_MILESTONES)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class);
    }

    public void addMilestone(int projectID, Map jsonMap) {

        given()
                .pathParams("project_id", projectID)
                .body(jsonMap)
                .post(Endpoints.ADD_MILESTONES)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(Milestone.class);
    }

    public void updateMilestone(int milestoneID, Map jsonAsMap) {

        given()
                .body(jsonAsMap)
                .when()
                .pathParams("milestone_id", milestoneID)
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void deleteMilestone(int milestoneID) {

        given()
                .when()
                .pathParams("milestone_id", milestoneID)
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);


    }

    public Response getMilestoneResponse(int milestoneID) {

        return given()
                .pathParams("milestone_id", milestoneID)
                .get(Endpoints.GET_PROJECT);


    }
}