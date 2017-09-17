package jbehave.steps;

import com.structure.core.pages.HotelsSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class HotelSearchPageSteps extends ScenarioSteps {

    private HotelsSearchPage hotelsSearchPage;

    private final static String DATE_SEPARATOR = ",";

    public HotelSearchPageSteps(final Pages pages) {
        super(pages);
        hotelsSearchPage = getPages().getPage(HotelsSearchPage.class);
    }

    @Step
    public void openPage() {
        hotelsSearchPage.open();
    }

    @Step
    public void typeDestination(final String destination) {
        hotelsSearchPage.getSearchByCriteriaPanel()
                .fillDestination(destination);
    }

    @Step
    public void typeCheckInDate(final String checkInDate) {
    }

    @Step
    public void typeCheckOutDate(final String checkOytDate) {
    }
}
