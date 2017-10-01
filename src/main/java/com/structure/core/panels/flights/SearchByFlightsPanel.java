package com.structure.core.panels.flights;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchByFlightsPanel  extends AbstractPanel{

    private static final String DEPARTURE_CITY = "(.//input[@placeholder='From where?'])[1]";

    private static final String ARRIVAL_CITY = "(.//input[@placeholder='To where?'])[1]";

    private static final String OPEN_DATE_PANEL = "//div [@class='col-start']";
    private static final String DATE_FILD = "//div [@ct-datepicker='true'][1]";

    private static final String SEARCH_BUTTON = ".//button[@id='Bkz5-submit']";

    //private static final Logger LOGGER = Logger.getLogger(SearchByFlightsPanel.class);

    public SearchByFlightsPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
       // com.structure.logging.Logger.out.debug();
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

    public FlightsDatesPickerPanel openCheckDatePicker() {
        if (!findBy(DATE_FILD).isCurrentlyVisible()) {
            findBy(OPEN_DATE_PANEL).then().click();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new FlightsDatesPickerPanel(findBy(DATE_FILD), getDriverDelegate());
    }

    public void search (){
        findBy(SEARCH_BUTTON).then().click();
    }
}
