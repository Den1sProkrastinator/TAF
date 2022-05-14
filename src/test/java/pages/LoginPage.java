package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Блок описания селекторов для элементов
    private By emailInputLocator = By.id("name");
    private By pswInputLocator = By.id("password");
    private By logInButtonLocator = By.id("button_primary");
    private By errorTextLocator = By.className("error-text");

    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return waitService.waitForExist(emailInputLocator);
    }
    public WebElement getPswInput() {
        return waitService.waitForExist(pswInputLocator);
    }
    public WebElement getLogInButton() {
        return waitService.waitForExist(logInButtonLocator);
    }
    public WebElement getErrorTextElement() { return waitService.waitForExist(errorTextLocator);
    }
}
