import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalculatorDependencyTest extends BaseTest {
    @Test
    public void stepB(){
        Assert.assertEquals(calculator.div(4,2),2, "wrong division");
        System.out.println("stepB...");
    }

    @Test(dependsOnMethods ="stepB" )
    public void stepA(){
        Assert.assertEquals(calculator.div(4,2),2, "wrong division");
        System.out.println("stepA...");
    }

    @Test(dependsOnMethods ="stepA")
    public void stepD() {
        Assert.assertEquals(calculator.div(4, 2), 3, "wrong division");
        System.out.println("stepD...");
        Assert.assertTrue(false);

    }

    @Test(dependsOnMethods = {"stepD","stepB"},alwaysRun = true )
    public void stepG(){
        Assert.assertEquals(calculator.div(6,2),3, "wrong division");
        System.out.println("stepG...");
    }


}
