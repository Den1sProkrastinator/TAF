package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    //locators
    private SelenideElement navigationMenu = $("#navMenu");


    //corpuscular methods
    public SelenideElement getNavigationMenu() {
        return navigationMenu;
    }


    //complex methods

}
