import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalculatorRetryTest extends BaseTest {
    private int attempt = 1;

    @Test(dataProvider = "dataProviderForRetryTest", dataProviderClass = StaticProvider.class, threadPoolSize = 2,
            retryAnalyzer = CalculatorRetry.class)
    public void retryTest(int a, int b, int expectedResult, String unexpectedMessage) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, unexpectedMessage);

    }
}
