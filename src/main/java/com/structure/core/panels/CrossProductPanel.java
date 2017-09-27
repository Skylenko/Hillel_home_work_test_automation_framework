package com.structure.core.panels;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;

public class CrossProductPanel extends AbstractPanel {

    private static final String BUTTON_FLIGHTS = "(.//a[@class='xpb-link'])[1]";

    public CrossProductPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickButtonFlights() {
        findBy(BUTTON_FLIGHTS).then().click();
        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
    }
}
