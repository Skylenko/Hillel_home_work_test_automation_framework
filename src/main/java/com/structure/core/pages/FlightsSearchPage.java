package com.structure.core.pages;

import com.structure.core.panels.SearchByFlightsPanel;
import com.structure.core.webdriver.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://booking.kayak.com/")

public class FlightsSearchPage extends AbstractPage {
    public FlightsSearchPage(WebDriver driver) {
        super(driver); }

    private static final String SEARCH_BY_FLIGHTS_PANEL = "//section[@class='form-section']";

    public SearchByFlightsPanel getSearchByFlightsPanel() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(SEARCH_BY_FLIGHTS_PANEL);
        return new SearchByFlightsPanel(findBy(SEARCH_BY_FLIGHTS_PANEL), this);
    }
}
