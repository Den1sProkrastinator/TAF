import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewCalculatorParamTest extends BaseTest{

    @Parameters({"login-value", "psw-value"})
    @Test
    public  void paramTest(@Optional("Default login")String login,@Optional("133123")String psw){
        System.out.println("Login is: "+login);
        System.out.println("pasword is "+ psw);
    }

}
