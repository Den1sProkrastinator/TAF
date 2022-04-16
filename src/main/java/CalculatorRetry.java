import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CalculatorRetry implements IRetryAnalyzer
{
    private  int attempt=1;
    private static final int MAX_RETRY=6;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if(attempt<MAX_RETRY){
            attempt++;
            return  true;
        }
        return false;
    }
}
