package org.concordion.cubano.template.driver.ui.westpac;

import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.driver.ui.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KiwisaverPage extends PageObject<KiwisaverPage> {
    public KiwisaverPage(BrowserBasedTest test) {
        super(test);
    }

    @FindBy(xpath = "//h1[contains(text(), 'KiwiSaver')]")
    WebElement heading;

    @FindBy(xpath = "//span[contains(text(), 'Retirement Calculator')]")
    WebElement kiwisaverCalculatorLink;

    @Override
    public ExpectedCondition<?> pageIsLoaded(Object... params) {
        return ExpectedConditions.visibilityOf(heading);
    }

    public KiwisaverCalculatorPage gotoCalculator() {

        return capturePageAndClick(kiwisaverCalculatorLink, KiwisaverCalculatorPage.class);

    }

}
