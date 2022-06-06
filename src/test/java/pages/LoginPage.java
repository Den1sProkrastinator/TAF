package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import tests.SelenideTest;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement userName = $(By.id("name"));

    public SelenideElement  psw =$("#password");



    public SelenideElement button= $("#button_primary");




}
