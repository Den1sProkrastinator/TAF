package steps.defs;

import baseEntities.BaseCucumberTEst;
import configuration.ReadProperties;
import io.cucumber.java.en.When;

public class SeconStepDefs extends BaseCucumberTEst {
    private  BaseCucumberTEst baseCucumberTEst;

    public SeconStepDefs(BaseCucumberTEst baseCucumberTEst) {
        this.baseCucumberTEst = baseCucumberTEst;
    }

    @When("loginpage is opened")
    public void loginpageIsOpened() {
    baseCucumberTEst.driver.get(ReadProperties.getUrl());
    }
}
