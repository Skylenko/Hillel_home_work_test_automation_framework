package jbehave.scenariosteps;

import jbehave.steps.HotelSearchPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class BookingSearchScenario {

    @Steps
    private HotelSearchPageSteps hotelSearchPageSteps;

    @Given("user has opened 'Booking.com' site")
    @Alias("user Denis has opened 'Booking.com' site")
    public void userOpenedSite() {
        hotelSearchPageSteps.openPage();
    }

    @When("user selects 'Destination' by using following value: '$destination'")
    public void typeDestination(final String destination) {
        hotelSearchPageSteps.typeDestination(destination);
    }

    @When("user selects 'Check In' date by using following date: '$checkInDate'")
    public void typeCheckInDate(final String checkInDate) {
    }

    @When("user selects 'Check Out' date by using following date: '$checkOutDate'")
    public void typeCheckOutDatefinal(final String checkOutDate) {
    }

    @When("user clicks on 'Search' button")
    public void clickSearchButton() {
    }

    @Then("each item from 'Search Result' list contains '$searchedText'")
    public void isSearchResultListContainSearchText(final String searchedText) {
    }

}
