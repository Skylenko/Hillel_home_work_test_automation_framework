package jbehave.steps;

import com.structure.core.pages.FlightsSearchPage;
import com.structure.core.pages.HotelsSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class FlightsSearchPageSteps extends ScenarioSteps {

    private HotelsSearchPage hotelsSearchPage;

    private FlightsSearchPage flightsSearchPage;

    public FlightsSearchPageSteps(final Pages pages) {
        super(pages);
        hotelsSearchPage = getPages().getPage(HotelsSearchPage.class);
        flightsSearchPage = getPages().getPage(FlightsSearchPage.class);

    }

    @Step
    public void openPage() {
        hotelsSearchPage.open();
    }

    @Step
    public void clickFlightsButton() {
        hotelsSearchPage.getCrossProductPanel().clickButtonFlights();
    }


    @Step
    public void typeDepartureCity(final String departureCity) {
        flightsSearchPage.getSearchByFlightsPanel().inputDepartureCity(departureCity);
    }

    @Step
    public void typeArrivalCity(final String arrivalCity) {
        flightsSearchPage.getSearchByFlightsPanel().inputArrivalCity(arrivalCity);
    }

    @Step
    public void typeDepartureDate(final String departureDate) {
    }

    @Step
    public void typeArrivalDate(final String arrivalDate) {

    }

    @Step
    public void clickSearchButton() {

    }
}



