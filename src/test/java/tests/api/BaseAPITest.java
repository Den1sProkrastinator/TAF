package tests.api;

import configuration.ReadProperties;
import helpers.MilestoneHelper;
import helpers.ProjectHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseAPITest {

    public ProjectHelper projectHelper;
    public MilestoneHelper milestoneHelper;

    @BeforeTest
    public void setupEnv() {
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());
//                .pathParams("project_id",72);
        projectHelper = new ProjectHelper();
        milestoneHelper = new MilestoneHelper();
    }
}
