package com.structure.core.pages.flights;

import com.structure.core.panels.flights.ResultPanel;
import com.structure.core.panels.flights.SearchByFlightsPanel;
import com.structure.core.webdriver.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FlightsSearchPage extends AbstractPage {
    public FlightsSearchPage(WebDriver driver) {
        super(driver);
    }

    private static final String SEARCH_BY_FLIGHTS_PANEL = "//section[@class='form-section']";
    private static final String RESULTS_PANEL = "//div[@class='Base-Results-ResultsList Flights-Results-FlightResultsList']";

    public SearchByFlightsPanel getSearchByFlightsPanel() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(SEARCH_BY_FLIGHTS_PANEL);
        return new SearchByFlightsPanel(findBy(SEARCH_BY_FLIGHTS_PANEL), this);
    }

    public ResultPanel getResultPanel() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(RESULTS_PANEL);
        return new ResultPanel(findBy(RESULTS_PANEL), this);
    }
}
