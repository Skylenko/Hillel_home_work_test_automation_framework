package jbehave.scenariosteps;

import com.structure.core.panels.CrossProductPanel;
import jbehave.steps.CrossProductPanelSteps;
import jbehave.steps.FlightsSearchPageSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FlightsSearchScenario {
    @Steps
    private CrossProductPanelSteps crossProductPanelSteps;
    @Steps
    private FlightsSearchPageSteps flightsSearchPageSteps;

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
    }

    @When("user selects 'Arrival' date by using following date: $arrivalDate")
    public void typeArrivalDate(final String arrivalDate) {
    }

    @When("user clicks on 'Search' button")
    public void clickSearchButton() {
    }

    @Then("each item from 'Search Result' list contains '$searchedText'")
    public void isSearchResultListContainsSearchText(final String searchedText) {
    }

}
