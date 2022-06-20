package tests.api;

import models.Milestone;
import org.testng.annotations.Test;
import configuration.Endpoints;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestoneAPITest extends BaseAPITest {

    private int milestoneID=101;
    private int projectID=72;



    @Test
    public void getMilestoneTest(){
        given()
                .when()
                .pathParams("milestone_id",milestoneID)
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void getMilestonesTest(){
        given()
                .when()
                .pathParams("project_id",projectID)
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addMilestoneTest(){
        Milestone milestone = Milestone.builder()
                .name("NewMilestone")
                .build();
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestone.getName());

        Milestone newMilestone = (Milestone) given()
                .body(jsonAsMap)
                .when()
                .pathParams("project_id",projectID)
                .post(Endpoints.ADD_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class);
    }

    @Test
    public void updateMilestoneTest(){

        Milestone milestone = Milestone.builder()
                .parentId(103)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("parent", milestone.getParentId());

        given()
                .body(jsonAsMap)
                .when()
                .pathParams("milestone_id",milestoneID)
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void deleteMilestoneTest(){
        given()
                .when()
                .pathParams("milestone_id",milestoneID)
                .delete(Endpoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
