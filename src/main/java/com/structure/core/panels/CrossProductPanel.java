package com.structure.core.panels;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class CrossProductPanel extends AbstractPanel {

    private static final String BUTTON_FLIGHTS = ".//a[@href='https://booking.kayak.com/in?p=searchbox_link&a=bdc%2Fsearchbox&sid=1a5eca645b0dc768e9092c021f1eaf7f']";

    public CrossProductPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickButtonFlights() {
        findBy(BUTTON_FLIGHTS).then().click();
    }
}
