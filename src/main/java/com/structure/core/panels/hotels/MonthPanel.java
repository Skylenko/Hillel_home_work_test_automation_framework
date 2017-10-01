package com.structure.core.panels;

import com.structure.core.BaseDatePickerPanel;
import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;


public class MonthPanel extends AbstractPanel implements BaseDatePickerPanel {

    private static final String DAYS_OF_MONTH = ".//span[@class='c2-day-inner']";

    protected MonthPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }
    @Override
    public void selectDayByValue(final String day) {
        findMultipleBy(DAYS_OF_MONTH)
                .stream()
                .filter(element -> element.getText().equals(day))
                .findFirst()
                .ifPresent(WebElementFacade::click);
            }
}
