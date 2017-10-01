package jbehave.steps.hotels;

import com.structure.core.pages.hotels.HotelsSearchPage;
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
                .fillInDestination(destination);
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
        hotelsSearchPage.getSearchByCriteriaPanel()
                .openCheckInDatePicker()
                .selectDate(checkInDate[0])
                .selectDayByValue((checkInDate[1]));
    }

    private void typeCheckOutDate(final String[] checkOutDate) {
        hotelsSearchPage.getSearchByCriteriaPanel()
                .openCheckOutDatePicker()
                .selectDate(checkOutDate[0])
                .selectDayByValue((checkOutDate[1]));
    }

    @Step
    public void clickSearchButton() {
        hotelsSearchPage.getSearchByCriteriaPanel().clickSearchButton();
    }

}