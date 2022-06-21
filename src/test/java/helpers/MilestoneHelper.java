package helpers;

import configuration.Endpoints;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class MilestoneHelper {

    public Milestone getMilestone(int milestoneID){
        return given()
                .pathParams("milestone_id",milestoneID)
                .get(Endpoints.GET_MILESTONE)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class);
    }
}
