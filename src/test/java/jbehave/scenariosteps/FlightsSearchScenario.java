package jbehave.scenariosteps;

import jbehave.steps.flights.CrossProductPanelSteps;
import jbehave.steps.flights.FlightsSearchPageSteps;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FlightsSearchScenario {
    @Steps
    private CrossProductPanelSteps crossProductPanelSteps;
    @Steps
    private FlightsSearchPageSteps flightsSearchPageSteps;

    private static final String DELIMETR = ",";

    @Given("user has opened 'BookingFlights.com' site")
    public void userOpenedSite() {
        crossProductPanelSteps.openPage();
    }

    @When("user click on 'Flights' button")
    public void clickFlightsButton() {
        crossProductPanelSteps.clickFlightsButton();
    }

    @When("user selects 'Departure from' by using following value: '$departureCity'")
    public void typeDepartureCity(final String departureCity) {
        flightsSearchPageSteps.typeDepartureCity(departureCity);
    }

    @When("user selects 'Arrival to' by using following value: '$arrivalCity'")
    public void typeArrivalCity(final String arrivalCity) {
        flightsSearchPageSteps.typeArrivalCity(arrivalCity);
    }

    @When("user selects 'Departure' date by using following date: $departureDate")
    public void typeDepartureDate(final String departureDate) {
        final String[] dates = StringUtils.split(departureDate, DELIMETR);
        flightsSearchPageSteps.selectDate(dates, true);
    }

    @When("user selects 'Arrival' date by using following date: $arrivalDate")
    public void typeArrivalDate(final String arrivalDate) {
        final String[] dates = StringUtils.split(arrivalDate, DELIMETR);
        flightsSearchPageSteps.selectDate(dates, true);
    }

    @When("user clicks on 'Search' button")
    public void clickSearchButton() {
        flightsSearchPageSteps.clickSearchButton();
    }

    @Then("each item from 'Search Result' list contains '$searchedText'")
    public void isSearchResultListContainsSearchText(final String searchedText) {
    }

}
