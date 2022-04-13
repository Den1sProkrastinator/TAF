import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
    @Test
    public void stepb(){
        System.out.println("stepb...");
    }

    @Test(dependsOnMethods ="stepb" )
    public void stepa(){
        System.out.println("stepa...");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods ="stepa",alwaysRun = true)

    public void stepd(){
        System.out.println("stepd...");

    }@Test(dependsOnMethods ="stepd" )
    public void stepg(){
        System.out.println("stepg...");
    }
    @Test(dependsOnMethods = {"stepg","stepa"} )
    public void stepf(){
        System.out.println("stepf...");
    }


}
