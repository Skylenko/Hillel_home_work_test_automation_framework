package com.structure.core.panels.flights;

import com.google.common.collect.Lists;
import com.structure.core.BaseDatePickerPanel;
import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;

public class FlightsMonthPanel extends AbstractPanel implements BaseDatePickerPanel {

    private static final String DAYS_OF_MONTH = "//div [@class='col-day ']//div";
    private static final String DAYS_OF_MONTH_2 = "//div [@class='col-day']//div";

    protected FlightsMonthPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    @Override
    public void selectDayByValue(final String day) {
        List<WebElementFacade> aaa = new ArrayList<>();
        aaa.addAll(findMultipleBy(DAYS_OF_MONTH));
        aaa.addAll(findMultipleBy(DAYS_OF_MONTH_2));

        aaa.stream()
                .filter(element -> element.getText().equals(day))
                .findFirst()
                .ifPresent(WebElementFacade::click);
    }
}
