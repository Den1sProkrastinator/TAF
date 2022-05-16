package tests;

import com.google.gson.Gson;
import models.Project;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class SerializationTest {

    public SerializationTest() {
    }

    @Test
    public void objectToJsonTest() throws IOException {
        Gson gson = new Gson();
        Project project = new Project("Test Project", "big test data", false, 2);
        String objectJson = gson.toJson(project);
        System.out.println(objectJson);

        FileWriter file = new FileWriter("projectResult.json");
        gson.toJson(project, file);
        file.close();
    }
    @Test
    public void jsonToObjectTest(){
        Gson gson=new Gson();

        String json= "{\n" +
                "  \"name\": \"Test Project\",\n" +
                "  \"announcement\": \"big test data\",\n" +
                "  \"show_announcement\": false,\n" +
                "  \"type\": 2\n" +
                "}";

        Project projectFromString = gson.fromJson(json,Project.class);

        System.out.println(projectFromString.toString());
        System.out.println(projectFromString.getName());

    }
}
