package steps;

import baseEntities.BaseCucumberTEst;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import services.BrowsersService;

public class Hook extends BaseCucumberTEst {
    private BaseCucumberTEst baseCucumberTEst;

    public Hook(BaseCucumberTEst baseCucumberTEst) {
        this.baseCucumberTEst = baseCucumberTEst;
    }

    @Before
    public void initializeTest(Scenario scenario){
        System.out.println("Hook :Start browser");

        baseCucumberTEst.driver = new BrowsersService().getDriver();

    }
    @After
    public void  tearDown(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println("Make screenshot");

        }
        if (baseCucumberTEst!= null){
            baseCucumberTEst.driver.quit();
        }
    }
}
