package tests.api;


import configuration.Endpoints;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import models.Milestone;
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
    public void addMilestoneTest() {
        Milestone milestone = Milestone.builder()
                .name(" Milestone1")
                .description("Description")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestone.getName());
        jsonAsMap.put("description", milestone.getDescription());

        milestoneHelper.addMilestone(72,jsonAsMap);


    }

    @Test
    public void deleteMilestoneTEst(){
        milestoneHelper.deleteMilestone(256);
    }





}
