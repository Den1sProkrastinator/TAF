import org.testng.annotations.Test;

public class PriorityTest {
    @Test(priority = 1)
    public void stepb(){
        System.out.println("stepb...");
    }
    @Test(priority = 2)
    public void stepa11(){
        System.out.println("stepa11...");
    } @Test(priority = 3)
    public void stepa2(){
        System.out.println("stepa11...");
    }
    @Test(priority = 4)
    public void stepd3(){
        System.out.println("stepd3...");
    }@Test(priority = 5)
    public void stepg(){
        System.out.println("stepg...");
    }@Test(priority = 6)
    public void stepf(){
        System.out.println("stepf...");
    }


}
