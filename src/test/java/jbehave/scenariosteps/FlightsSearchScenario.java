package jbehave.scenariosteps;

import jbehave.steps.FlightsSearchPageSteps;
import jbehave.steps.HotelSearchPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FlightsSearchScenario {
    @Steps
    private HotelSearchPageSteps hotelSearchPageSteps;

    private FlightsSearchPageSteps flightsSearchPageSteps;

    @Given("user has opened 'Booking.com' site")

    public void userOpenedSite() {
        hotelSearchPageSteps.openPage();
    }

    @When("user clicks on 'Flights' button")
    public void clickFlightsButton() {
        flightsSearchPageSteps.clickFlightsButton();
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
    public void isSearchResultListContainSearchText(final String searchedText) {
    }

}
