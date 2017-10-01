package jbehave.steps.flights;

import com.structure.core.pages.flights.FlightsSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class FlightsSearchPageSteps extends ScenarioSteps {

    private FlightsSearchPage flightsSearchPage;

    public FlightsSearchPageSteps(final Pages pages) {
        super(pages);
        flightsSearchPage = getPages().getPage(FlightsSearchPage.class);

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

    public void selectDate(final String[] dates, final boolean isCheckInDate) {
        if (isCheckInDate) {
            typeCheckInDate(dates);
        } else {
            typeCheckOutDate(dates);
        }
    }

    private void typeCheckInDate(final String[] checkInDate) {
        flightsSearchPage.getSearchByFlightsPanel()
                .openCheckDatePicker()
                .selectDates(checkInDate[0])
                .selectDayByValue((checkInDate[1]));
    }

    private void typeCheckOutDate(final String[] checkOutDate) {
        flightsSearchPage.getSearchByFlightsPanel()
                .openCheckDatePicker()
                .selectDates(checkOutDate[0])
                .selectDayByValue((checkOutDate[1]));
    }


    @Step
    public void clickSearchButton() {

    }
}



