import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalculatorGroupTest extends BaseTest
{
    @Test(groups = "smoke")
    public void step1()
    {
        System.out.println("step1  smoke");
        Assert.assertEquals(calculator.div(10,2),5, "wrong division");
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
    }

    @Test(groups = {"regression","smoke"})
    public void step3()
    {
        System.out.println("step3 regression\",\"smoke");
        Assert.assertEquals(calculator.div(6,2),3, "wrong division");
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
    }

    @Test(groups = "smoke")
    public void step2()
    {
        System.out.println("step2 smoke");
        Assert.assertEquals(calculator.div(4,2),5, "wrong division");
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
    }
    @Test(groups = "regression")
    public void step4()
    {
        System.out.println("step2 smoke");
        Assert.assertEquals(calculator.div(4,2),2, "wrong division");
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
    }
}
