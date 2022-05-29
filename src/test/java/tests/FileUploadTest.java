package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test

    public void fileUploadTest(){
        fileUploadStep.fileUpload();

        Assert.assertEquals(fileUploadStep.getSuccessElement().getText(), "File Uploaded!\n" +
                "download.jpg");
    }
}
