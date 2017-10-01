package com.structure.core.panels.flights;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchByFlightsPanel extends AbstractPanel {

    private static final String DEPARTURE_CITY = "(.//input[@placeholder='From where?'])[1]";
    private static final String ARRIVAL_CITY = "(.//input[@placeholder='To where?'])[1]";
    private static final String OPEN_DATE_PANEL = ".//div [@class='col-start']";
    private static final String DATE_FILD = "//div [@ct-datepicker='true'][1]";
    private static final String SEARCH_BUTTON = "(.//button[@type='submit'])[1]";
    private static final String AUTOCOMPLETE_LIST_1 = ".//ul[@role='listbox']//li[1]";
    private static final String AUTOCOMPLETE_LIST_2 = ".//li[@data-short-name='Tel Aviv (TLV)']";

    public SearchByFlightsPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void inputDepartureCity(final String departureCity) {
        final WebElementFacade departure = findBy(DEPARTURE_CITY);
        departure.then().clear();
        departure.then().type(departureCity);
        final WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(AUTOCOMPLETE_LIST_1)));
        selectFirstItemFromAutoSuggestionList();
    }

    public void inputArrivalCity(final String arrivalCity) {
        final WebElementFacade arrival = findBy(ARRIVAL_CITY);
        arrival.then().type(arrivalCity);
        final WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(AUTOCOMPLETE_LIST_2)));
        selectFirstItemFromSecondAutoSuggestionList();
    }

    public FlightsDatesPickerPanel openCheckDatePicker() {
        if (!findBy(DATE_FILD).isCurrentlyVisible()) {
            findBy(OPEN_DATE_PANEL).then().click();
        }
        return new FlightsDatesPickerPanel(findBy(DATE_FILD), getDriverDelegate());
    }

    public void search() {
        findBy(SEARCH_BUTTON).then().click();
    }

    private void selectFirstItemFromAutoSuggestionList() {
        findMultipleBy(AUTOCOMPLETE_LIST_1)
                .stream()
                .findFirst()
                .ifPresent(WebElementFacade::click);
    }

    private void selectFirstItemFromSecondAutoSuggestionList() {
        findMultipleBy(AUTOCOMPLETE_LIST_2)
                .stream()
                .findFirst()
                .ifPresent(WebElementFacade::click);
    }
}
