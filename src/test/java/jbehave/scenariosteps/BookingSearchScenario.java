package jbehave.scenariosteps;

import com.util.DbUtil;
import jbehave.steps.hotels.FilterPanelSteps;
import jbehave.steps.hotels.HotelSearchPageSteps;
import jbehave.steps.hotels.SearchResultPageSteps;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BookingSearchScenario {

    @Steps
    private HotelSearchPageSteps hotelSearchPageSteps;

    @Steps
    private SearchResultPageSteps searchResultPageSteps;

    @Steps
    private FilterPanelSteps filterPanelSteps;

    private static final String DELIMETR = ",";

    @Given("user has opened 'Booking.com' site")
    public void userOpenedSite() {
        hotelSearchPageSteps.openPage();
    }

    @When("user selects 'Destination' by using following value: '$destination'")
    public void typeDestination(final String destination) {
        hotelSearchPageSteps.typeDestination(destination);
    }

    @When("user selects 'Destination' by using following values:$values")
    public void selectDestination(final ExamplesTable examplesTable) throws SQLException {

        final List<Map<String, String>> rows = examplesTable.getRows();
        for (int index = 0; index < rows.size(); index++) {
            final Map<String, String> row = rows.get(index);
            final String destinationValue = row.get("destination");
            final String checkInDate = row.get("checkInDate");
            final String checkOutDate = row.get("checkOutDate");
            typeDestination(destinationValue);
            typeCheckInDate(checkInDate);
            typeCheckOutDate(checkOutDate);
        }
        //DbUtil.connectToDb();
    }

    @When("user selects 'Check In' date by using following date: '$checkInDate'")
    public void typeCheckInDate(final String checkInDate) {
        final String[] dates = StringUtils.split(checkInDate, DELIMETR);
        hotelSearchPageSteps.selectDate(dates, true);
    }

    @When("user selects 'Check Out' date by using following date: '$checkOutDate'")
    public void typeCheckOutDate(final String checkOutDate) {
        final String[] dates = StringUtils.split(checkOutDate, DELIMETR);
        hotelSearchPageSteps.selectDate(dates, false);
    }

    @When("user click on 'Search' button")
    public void clickSearchButton() {
        hotelSearchPageSteps.clickSearchButton();
    }


    @When("user clicks on 'Superb' checkbox")
    public void checkAmasingFiltr() {
        filterPanelSteps.checkAmasingFiltr();
    }

    @When("user clicks on another 'Free cancellation' checkbox")
    public void checkCancellationFiltr() {
        filterPanelSteps.checkCancellationFiltr();
    }

    @Then("each items from 'Search Result' list contains '$firstFilter'")
    public void isSearchResultListContainsFirstFilterParameter(final String firstFilter){
        Assert.assertTrue(filterPanelSteps.isSearchResultListContainsFirstFilterParameter(firstFilter));
    }

    @Then("each item from 'Search Result' list contain '$secondFilter'")
    public void isSearchResultListContainsSecondFilterParameter(final String secondFilter) {
        Assert.assertTrue(filterPanelSteps.isSearchResultListContainsSecondFilterParameter(secondFilter));
    }
    @Then("all item from 'Search Result' list contains '$searchedText'")
    public void isSearchResultListContainSearchText(final String searchedText) {
        Assert.assertTrue(searchResultPageSteps.isSearchResultListContainSearchText(searchedText));
    }

}
