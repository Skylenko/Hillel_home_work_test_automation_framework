package com.structure.core.panels;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchByFlightsPanel  extends AbstractPanel{

    private static final String DEPARTURE_CITY = "(.//input[@placeholder='From where?'])[1]";

    private static final String ARRIVAL_CITY = "(.//input[@placeholder='To where?'])[1]";

    private static final String DATE_FILD = "(//div[@class='dateInput size-l input-flat'])[1]";

    private static final String SEARCH_BUTTON = ".//button[@id='Bkz5-submit']";

    public SearchByFlightsPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public FlightsDatesPickerPanel openCheckOutDatePicker() {
        findBy(DATE_FILD).then().click();
        return new FlightsDatesPickerPanel(findBy(DATE_FILD), getDriverDelegate());
    }

    public void inputDepartureCity(final  String departureCity){
        final WebElementFacade departure = findBy(DEPARTURE_CITY);
        departure.then().clear();
        departure.then().type(departureCity);
    }

    public void inputArrivalCity(final String arrivalCity){

        final WebElementFacade arrival = findBy(ARRIVAL_CITY);
        arrival.then().type(arrivalCity);
    }

    public void search (){
        findBy(SEARCH_BUTTON).then().click();

    }
}
