package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "dataForSum")
    public static Object[][]dataForTest(){
        return  new Object[][]{
                {-2,-3,-5},
                {0,0,0},
                {2,3,5}
        };
    }

    @DataProvider (name ="datForIntDiv")
    public static Object[][]dataForTestDivInt(){
        return  new Object[][]{
                {10,5,2 , "Верно"},
                {11,2,6, "вот если бы ты  постарался и допилил \"нормальное\" округление - тогда бы и поговорили "},
                {11,0,0 , "тут должна быть ваша арифметик ошибка "},
        };
    }
    @DataProvider(name = "dataForTestDivDouble")
    public static Object[][] dataForTestDivDouble(){
        return new Object[][]{
                {12.0,2.0,6.0, "Вероно"},
                {13.0, 2.0, 6.5,"Верно"},

        };
    }

    @DataProvider(name = "dataProviderForRetryTest")
    public static Object[][] dataProviderForRetryTest(){
        return new Object[][]{
                {1,0,1,"ошибка"},
                {2,0,1,"ошибка"},
                {3,0,1,"ошибка"},
                {4,0,1,"ошибка"},
                {5,5,1,"не должно быть ошибки"}
        };
    }
}
