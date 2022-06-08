package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import tests.SelenideTest;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement email = $("[type='text']");

    public SelenideElement  psw =$("[type='password']");



    public SelenideElement button= $(".button.is-vcentered");




}
