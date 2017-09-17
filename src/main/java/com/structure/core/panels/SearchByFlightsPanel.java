package com.structure.core.panels;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchByFlightsPanel  extends AbstractPanel{

    private static final String DEPARTURE_CITY = ".//input[@id='Bkz5-origin']";

    private static final String ARRIVAL_CITY = ".//input[@id='Bkz5-destination']";

    private static final String SEARCH_BUTTON = ".//button[@id='Bkz5-submit']";

    public SearchByFlightsPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void inputDepartureCity(final  String departureCity){
        findBy(DEPARTURE_CITY).then().type(departureCity);

    }

    public void inputArrivalCity(final String arrivalCity){

        findBy(ARRIVAL_CITY).then().type(arrivalCity);
    }


}
