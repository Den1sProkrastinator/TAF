package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class CssSelectorsTest {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = new BrowsersService().getDriver();

    }



    @Test
    public  void  CssSelectorsTest() throws InterruptedException {
        driver.get("C:\\TeachMeSkilsCourse\\TAF\\src\\test\\resources\\index.html");

//  поиск по айди в ssSelector
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());


        //Find by className is Css selectors

        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());


        // поиск по нескольким зачениям в атрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        //поиск оп тегу

        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());

        //поиск по teg  и значению из атрибута class

        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());

        //поиск по tag  и значению атрибута класс
        Assert.assertEquals(2,driver.findElements(By.cssSelector("#Lastname .markup")).size());

        //поиск всех элементов с тегом 1 ли p
        Assert.assertEquals(8,driver.findElements(By.cssSelector("h1, p")).size());

        //поиск всех элементов c тегом р у которых непосредственный родитель div

        Assert.assertEquals(6,driver.findElements(By.cssSelector("div > p")).size());


        //поиск всех р элементов которые идут сразу за тегом ul

        Assert.assertEquals(1,driver.findElements(By.cssSelector("ul+p")).size());

        //поиск всех  элементов с тегом div которые является братьями элементу с тегом p

        Assert.assertEquals(2,driver.findElements(By.cssSelector("p~div")).size());

        //поиск всех эементов у которых присутствует атрибут title

        Assert.assertEquals(1,driver.findElements(By.cssSelector("title")).size());

        //поиск всех эементов у которых присутствует атрибут style  конкретным значением

        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        //поиск  элемента с атрибутом id  со значением заканчивающимся на какое-то valye'
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$=ess]")).size());

        //поиск  элемента с атрибутом id   начинающемся  на какое-то value или value-'
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        //поиск  элемента с атрибутом id   начинающемся  на какое-то value или value-'
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        //поиск  элемента с атрибутом id   начинающемся  нс какого-то символа
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id^=L]")).size());

        //поиск  элемента с атрибутом title   одержащим слово
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        //поиск  элемента с атрибутом title   одержащим какойто текст
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*=beaut]")).size());

        //поиск  всех disable елементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disable")).size());

        //поиск  всех enable елементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":enable")).size());

        //поиск выбранных(отмеченые галочками ) элементов checked
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":checked")).size());

        //поиск empty  пустых елементов  с путым телом
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":empty")).size());

        //поиск элемента с тегом р и который является первым дочерним
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        //поиск элемента с тегом р и который является последним  лементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:last-child")).size());

        //поиск элемента с тегом р и который является n дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());

        //поиск элемента с тегом р и который является even (четным)
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(even)")).size());

        //поиск элемента с тегом р и который является even (odd)
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(odd)")).size());

        //поиск эелемента  с тегом b который евляется динственнм ребенком

    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
