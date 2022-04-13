import org.testng.annotations.*;
@Listeners(Listener.class)
public class BaseTest {
    protected Calculator calculator = new Calculator("Test calculator");

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite...");}

        @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest...");}

        @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass...");}

        @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod...");  }

        @BeforeGroups
    public void beforeGroups(){
        System.out.println("beforeGroups...");

    } @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite...");
    }

        @AfterTest
    public void afterTest(){
        System.out.println("afterTest...");
    }

        @AfterSuite
    public void afterClass(){
        System.out.println("afterClass...");
    }

        @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod...");
    }

        @AfterGroups
    public void afterGroups(){
        System.out.println("afterGroups...");

    }
}
