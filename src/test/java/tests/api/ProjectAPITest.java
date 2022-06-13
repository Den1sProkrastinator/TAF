package tests.api;

import helpers.ProjectHelper;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectAPITest extends BaseApitTest{




    @Test
    public void positiveTest(){
        Project expectedProject = Project.builder()
                .typeOfProject(1)
                .name("Denis_QA18_PO_HW")
                .announcement("Test An")
                .build();

        Project actualProject = projectHelper.getProject(1);
        Assert.assertTrue(actualProject.equals(expectedProject));

    }

    @Test
    public void negativeInvalidProjectTest(){
        Assert.assertEquals(projectHelper.getProjectResponse(500).getStatusCode(),400);

    }


    @Test
    public void positiveCountProjectTest(){
        Assert.assertEquals(projectHelper.getAllProject().length,10);

    }

}
