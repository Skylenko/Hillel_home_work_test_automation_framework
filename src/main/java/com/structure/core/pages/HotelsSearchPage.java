package com.structure.core.pages;

import com.structure.core.panels.SearchByCriteriaPanel;
import com.structure.core.webdriver.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@DefaultUrl("http://www.booking.com/index.en-gb.html")
public class HotelsSearchPage extends AbstractPage {

    private static final String SEARCH_BY_CRITERIA_PANEL = "//form[@id='frm']";

    public HotelsSearchPage(final WebDriver driver) {
        super(driver);
    }

    public SearchByCriteriaPanel getSearchByCriteriaPanel() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(SEARCH_BY_CRITERIA_PANEL);
        return new SearchByCriteriaPanel(findBy(SEARCH_BY_CRITERIA_PANEL), this);
    }
}
