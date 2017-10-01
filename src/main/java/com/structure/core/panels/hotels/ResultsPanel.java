package com.structure.core.panels.hotels;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPanel extends AbstractPanel {

    private static final String SEARCH_RESULT_ITEMS = ".//div[@class='sr_property_block_main_row']";
    private static final String SEARCH_RESULT_BY_MARK_FILTER = ".//span[@class=' review-score-widget review-score-widget__superb review-score-widget__text-only   review-score-widget__right  review-score-widget__20      ']//span[1]";
    private static final String SEARCH_RESULT_BY_CANCELLETION = ".//tr[@class='roomrow entire_row_clickable']";

    public ResultsPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public List<String> getResultItemsByFirstFilter() {
        return findMultipleBy(SEARCH_RESULT_BY_MARK_FILTER)
                .stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    public List<String> getResultBySecondFilter() {
        return findMultipleBy(SEARCH_RESULT_BY_CANCELLETION)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public List<String> getResultItems() {
        return findMultipleBy(SEARCH_RESULT_ITEMS)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

}
