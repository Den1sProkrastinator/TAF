package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import tests.SelenideTest;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {



    //locators
    public SelenideElement email = $("[type='text']");

    public SelenideElement  psw =$("[type='password']");
    public SelenideElement button= $(".button.is-vcentered");

    public SelenideElement alertText=$(".notification.is-danger");


    //corpuscular methods

    public SelenideElement getEmail() {
        return email;
    }

    public SelenideElement getPsw() {
        return psw;
    }

    public SelenideElement getButton() {
        return button;
    }

    public SelenideElement getAlertText() {
        return alertText;
    }

    public LoginPage successLogin(){

    }


}
