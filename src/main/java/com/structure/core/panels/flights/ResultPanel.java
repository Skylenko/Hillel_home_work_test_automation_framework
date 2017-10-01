package com.structure.core.panels.flights;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPanel extends AbstractPanel {

    private static final String SEARCH_RESULT = ".//div[@class='col-field time depart'][.//div[contains(text(), 'TLV')]]";

    public ResultPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public List<String> getResultByParameter() {
        return findMultipleBy(SEARCH_RESULT)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
