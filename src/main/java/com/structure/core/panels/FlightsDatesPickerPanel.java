package com.structure.core.panels;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class FlightsDatesPickerPanel extends AbstractPanel {

    private static final String MONTH_PANEL =" ";
    private static final String NEXT_MONTH_CLICK = "";

    protected FlightsDatesPickerPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public MonthPanel selectDate(final String monthAndYear) {
        final WebElementFacade monthPanel = findBy(String.format(MONTH_PANEL, monthAndYear));
        while (!monthPanel.isDisplayed()) {
            findBy(NEXT_MONTH_CLICK).then().click();

        }return new MonthPanel(monthPanel, getDriverDelegate());
    }
}
