package com.structure.core.panels.hotels;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class DatePickerPanel extends AbstractPanel {

    private static final String MONTH_TABLE_PANEL = ".//table[.//th[contains(text(), '%s')]]";
    private static final String NEXT_MONTH_BUTTON = "(.//div[contains(@class, 'c2-button c2-button-further')]/span)[1]";

    protected DatePickerPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public MonthPanel selectDate(final String monthAndYear) {
        final WebElementFacade monthPanel = findBy(String.format(MONTH_TABLE_PANEL, monthAndYear));
        while (!monthPanel.isDisplayed()) {
            findBy(NEXT_MONTH_BUTTON).then().click();

        }
        return new MonthPanel(monthPanel, getDriverDelegate());
    }

}
