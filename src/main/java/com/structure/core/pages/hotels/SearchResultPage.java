package com.structure.core.pages.hotels;

import com.structure.core.panels.FilterPanel;
import com.structure.core.panels.ResultsPanel;
import com.structure.core.webdriver.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class SearchResultPage extends AbstractPage {

    private static final String RESULTS_PANEL = "//div[@id='hotellist_inner']";
    private static final String FILTER_PANEL = "//div[@id='filterbox_options']";

    public SearchResultPage(final WebDriver driver) {
        super(driver);
    }

    public ResultsPanel getResultsPanel() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(RESULTS_PANEL);
        return new ResultsPanel(findBy(RESULTS_PANEL), this);
    }

    public FilterPanel getFilterPanel(){
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(FILTER_PANEL);
        return new FilterPanel(findBy(FILTER_PANEL), this);
    }
}
