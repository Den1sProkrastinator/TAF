package steps.defs;

import baseEntities.BaseCucumberTEst;
import io.cucumber.java.en.Given;

public class MainStepDefs extends BaseCucumberTEst {
    private  BaseCucumberTEst baseCucumberTEst;

    public MainStepDefs(BaseCucumberTEst baseCucumberTEst) {
        this.baseCucumberTEst = baseCucumberTEst;
    }

    @Given("Chrome is started")
    public void chromeIsStarted() {
        baseCucumberTEst.driver.get("http://onliner.by");


    }
}
