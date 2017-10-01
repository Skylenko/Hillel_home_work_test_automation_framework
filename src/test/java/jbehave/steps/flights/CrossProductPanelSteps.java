package jbehave.steps.flights;

import com.structure.core.pages.hotels.HotelsSearchPage;
import com.structure.core.pages.hotels.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;

public class CrossProductPanelSteps extends ScenarioSteps {

    private HotelsSearchPage hotelsSearchPage;

    public CrossProductPanelSteps(final Pages pages) {
        super(pages);
        this.hotelsSearchPage = getPages().getPage(HotelsSearchPage.class);
    }

    @Step
    public void openPage() {
        hotelsSearchPage.open();

    }

    @Step
    public void clickFlightsButton() {
        hotelsSearchPage.getCrossProductPanel().clickButtonFlights();

       // getDriver().close();
       // getDriver().switchTo().window(tabs2.get(0));

    }
}
