import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class NewCalculatorTestWithAllAttributes extends BaseTest {

    @Test
    public void testDivInt(){
        Assert.assertEquals(calculator.div(10,2),5, "wrong division");

    }
    @Test
    public void testDivDouble(){
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");

    }
    @Test
    public void testDivWrong(){
        Assert.assertEquals(calculator.div(11,2),6, "wrong division!!!!!");

    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testWithExecption (){
        Assert.assertEquals(calculator.div(10,0),0,"exception!");

    }

    @Test(timeOut = 1000)
    public  void timeOutTest() throws InterruptedException {
        Assert.assertEquals(calculator.div(10,2),5,"неверная сумма ");
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
        Thread.sleep(100);
    }

    @Test(invocationCount = 3,invocationTimeOut = 1000, threadPoolSize = 3)
    public  void invocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
        Assert.assertEquals(calculator.div(10,2),5,"неверная сумма ");
    }


    @Test(dataProvider = "datForIntDiv",dataProviderClass = StaticProvider.class,threadPoolSize = 3)
    public  void testIntDataProvider(int a,int b,int expectedResult,String unexpectedMessage)  {
        Assert.assertEquals(calculator.div(a,b),expectedResult,unexpectedMessage);
    }
    @Test(dataProvider ="dataForTestDivDouble" ,dataProviderClass = StaticProvider.class,threadPoolSize = 2)
    public void testDoubleDataProvider(double a, double b, double expectedResult,String unexpectedMessage){
        Assert.assertEquals(calculator.div(a,b),expectedResult, unexpectedMessage);
    }





    @Test(enabled = false)
    public void methodGonnaBeIgnored() {
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
        Assert.assertEquals(calculator.div(10,2),5, "wrong division");
        System.out.println("Этот метод будет проигнорирован в момент проведения тестирования!");
    }



}
