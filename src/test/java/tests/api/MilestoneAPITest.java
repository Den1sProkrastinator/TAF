package tests.api;

import models.Milestone;
import org.testng.annotations.Test;
import configuration.Endpoints;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestoneAPITest extends BaseAPITest {

//    private int milestoneID = 101;
    private int projectID;

    private List<Project> project = new ArrayList<>();

    private Project actualProject;



    //Positive tests
    @Test
    public void getMilestonePositiveTest() {

     milestoneHelper.getMilestone(256);


    }

    @Test
    public void getMilestonesPositiveTest() {
     milestoneHelper.getMilestones(72);

    }

    @Test
    public void addMilestonePositiveTest() {
        Milestone milestone = Milestone.builder()
                .name("DenisMilestoneAPI")
                .build();
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestone.getName());

       milestoneHelper.addMilestone(72,jsonAsMap);
    }

    @Test
    public void updateMilestonePositiveTest() {

        Milestone milestone = Milestone.builder()
                .parentId(103)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("parent", milestone.getParentId());


    }


    @Test
    public void deleteMilestonePositiveTest() {
        given()
                .when()
                .pathParams("milestone_id",256)
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    //Negative tests


}

