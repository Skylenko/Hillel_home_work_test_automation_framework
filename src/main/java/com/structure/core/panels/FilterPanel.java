package com.structure.core.panels;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.concurrent.TimeUnit;

public class FilterPanel extends AbstractPanel {

    private static final String CHECK_POPULAR = "//*[@id='filter_review']/div[2]/a[1]";
    private static final String CHECKED_POPULAR = "(//a[@aria-checked='true'])[2]";
    private static final String CHECK_CANCELLATION = "//a[@data-id='fc-2']";

    public FilterPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void checkFirstFiltr() {
        findBy(CHECK_POPULAR).withTimeoutOf(5, TimeUnit.SECONDS).then().click();
    }

    public void checkSecondFiltr() {
        isElementPresent(CHECKED_POPULAR);
        findBy(CHECK_CANCELLATION).then().click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
