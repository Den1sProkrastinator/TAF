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
}
