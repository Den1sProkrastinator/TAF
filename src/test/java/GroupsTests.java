import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTests {
    @Test(groups = "smoke" )
    public void stepb(){
        System.out.println("smoke...stepb");
    }

    @Test(groups = "regression" )
    public void stepa(){
        System.out.println("regression...stepa");

    }

    @Test(groups = "regression" )
    public void stepd(){
        System.out.println("regression ...stepd");

    }
    @Test(groups = {"smoke","regression"})
    public void stepc(){
        System.out.println("smoke\",\"regression ...stepc");
    }

}
