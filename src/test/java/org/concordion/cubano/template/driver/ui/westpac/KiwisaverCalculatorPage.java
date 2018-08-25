package org.concordion.cubano.template.driver.ui.westpac;

import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.driver.ui.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KiwisaverCalculatorPage extends PageObject<KiwisaverCalculatorPage> {
    public KiwisaverCalculatorPage(BrowserBasedTest test) {
        super(test);
    }

    @FindBy(xpath = "//h1[contains(text(), 'Retirement Calculator')]")
    WebElement heading;

    @FindBy(xpath = "//a[@href='/kiwisaver/calculators/kiwisaver-calculator/']")
    WebElement retirementCalculatorLink;

    @Override
    public ExpectedCondition<?> pageIsLoaded(Object... params) {
        return ExpectedConditions.visibilityOf(heading);
    }

    public RetirementCalculatorPage gotoRetirementCalculator() {

        return capturePageAndClick(retirementCalculatorLink, RetirementCalculatorPage.class);
    }


}
