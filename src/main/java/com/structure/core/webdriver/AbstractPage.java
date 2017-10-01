package com.structure.core.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

public abstract class AbstractPage extends PageObject {

    private static final double RELATIVE_SCROLL_OFFSET = 0.33;
   // private final int defaultScrollOffset;

    public AbstractPage(final WebDriver driver) {
        super(driver);
      //  defaultScrollOffset = (int) Math.round(ScreenInfoUtil.getHeight() * RELATIVE_SCROLL_OFFSET);
        getDriver().manage().window().maximize();
    }

    protected boolean isElementPresent(final String xpathLocator) {
        setImplicitTimeout(500, MILLISECONDS);
        final boolean isElementsPresent = isNotEmpty(getDriver().findElements(By.xpath(xpathLocator))); //проверить наличие элемента
        resetImplicitTimeout();
        return isElementsPresent;

    }
}