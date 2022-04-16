import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class Listener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        System.out.println("Make  a screenshot great again...");
    }



}
