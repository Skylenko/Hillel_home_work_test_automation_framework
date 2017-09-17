package com.structure.core.panels;

import com.structure.core.webdriver.AbstractPage;
import com.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchByCriteriaPanel extends AbstractPanel {

    private static final String DESTINATION_INPUT = "(.//input[@id='ss'])[1]";

    public SearchByCriteriaPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void fillDestination(final  String destinationInfo){
        findBy(DESTINATION_INPUT).then().type(destinationInfo);

    }
}
