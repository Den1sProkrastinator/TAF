import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalculatorPriorityTest extends BaseTest {

    @Test(priority = 4)
            public void step1(){
        System.out.println("priority 4 ");
    Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
        Assert.assertEquals(calculator.div(12,2),6, "wrong division");
    }
    @Test(priority = 3)
    public void step2(){
        System.out.println("priority 3 ");
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
        Assert.assertEquals(calculator.div(12,2),6, "wrong division");
    }
    @Test(priority = 2)
    public void step3(){
        System.out.println("priority 2 ");
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
        Assert.assertEquals(calculator.div(12,2),6, "wrong division");
    }
    @Test(priority = 1)
    public void step4(){
        System.out.println("priority 1 ");
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
        Assert.assertEquals(calculator.div(12,2),6, "wrong division");
    }





}
