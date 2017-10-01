package com.structure.core.panels.flights;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class FlightsDatesPickerPanel extends AbstractPanel {

    private static final String MONTH_PANEL =".//div[@class='month'][.//div[contains(text(), '%s')]]";
    private static final String NEXT_MONTH_CLICK = "//div [@aria-label='Next month']";

    protected FlightsDatesPickerPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public FlightsMonthPanel selectDates(final String monthAndYear) {
        final WebElementFacade monthPanel = findBy(String.format(MONTH_PANEL, monthAndYear));
        while (!monthPanel.isDisplayed()) {
            findBy(NEXT_MONTH_CLICK).then().click();
        }return new FlightsMonthPanel(monthPanel, getDriverDelegate());
    }
}
