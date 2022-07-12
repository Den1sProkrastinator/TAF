import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(calculator.div(11.0,2.0),5.5, "wrong division");
        Thread.sleep(100);
    }

    @Test(invocationCount = 3,invocationTimeOut = 1000, threadPoolSize = 3)
    public  void invocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(10,2),5,"неверная сумма ");
    }

    @Test(dataProvider = "datForIntDiv",dataProviderClass = StaticProvider.class,threadPoolSize = 3)

    public  void testDataProvider(int a,int b,int expectedResult,String expectedMessage)  {
        Assert.assertEquals(calculator.div(a,b),expectedResult,expectedMessage);
    }





    @Test(enabled = false)
    public void methodGonnaBeIgnored() {
        Assert.assertEquals(calculator.div(10,2),5, "wrong division");
        System.out.println("Этот метод будет проигнорирован в момент проведения тестирования!");
    }



    // GROUP TESTS

    @Test(groups = "smoke")
    public void step1()
    {
        System.out.println("step1  smoke");
        Assert.assertEquals(calculator.div(10,2),5, "wrong division");
    }

    @Test(groups = {"regression","smoke"})
    public void step3()
    {
        System.out.println("step3 regression\",\"smoke");
        Assert.assertEquals(calculator.div(6,2),3, "wrong division");
    }

    @Test(groups = "smoke")
    public void step2()
    {
        System.out.println("step2 smoke");
        Assert.assertEquals(calculator.div(4,2),5, "wrong division");
    }
    @Test(groups = "regression")
    public void step4()
    {
        System.out.println("step2 smoke");
        Assert.assertEquals(calculator.div(4,2),2, "wrong division");
    }

    //Dependency Test

    @Test
    public void stepb(){
        Assert.assertEquals(calculator.div(4,2),3, "wrong division");
        System.out.println("stepb...");
    }

    @Test(dependsOnMethods ="stepb" )
    public void stepa(){
        System.out.println("stepa...");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods ="stepa",alwaysRun = true)

    public void stepd(){
        System.out.println("stepd...");

    }@Test(dependsOnMethods ="stepd" )
    public void stepg(){
        System.out.println("stepg...");
    }
    @Test(dependsOnMethods = {"stepg","stepa"} )
    public void stepf(){
        System.out.println("stepf...");
    }

    // ToDo: Отсутствуют тесты деления на 0
    // ToDo: Название тестовых методов - переделать согласно https://dzone.com/articles/7-popular-unit-test-naming
    // Todo: Между методами должна быть одна пустая строка
    // ToDo: Форматирование текста в классе Code -> Reformat Code
}
