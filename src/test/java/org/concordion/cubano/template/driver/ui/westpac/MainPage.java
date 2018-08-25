package org.concordion.cubano.template.driver.ui.westpac;

import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.AppConfig;
import org.concordion.cubano.template.driver.ui.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageObject<MainPage> {
    public MainPage(BrowserBasedTest test) {
        super(test);
    }

    @FindBy(className = "sw-header-logo")
    WebElement logo;

    @FindBy(id = "ubermenu-section-link-kiwisaver-ps")
    WebElement kiwisaverLink;

    @Override
    public ExpectedCondition<?> pageIsLoaded(Object... params) {
        return ExpectedConditions.visibilityOf(logo);
    }

    public static MainPage open(BrowserBasedTest test) {
        test.getBrowser().getDriver().navigate().to(AppConfig.getInstance().getSearchUrl());

        return new MainPage(test);
    }

    public KiwisaverPage gotoKiwisaver() {

        return capturePageAndClick(kiwisaverLink, KiwisaverPage.class);

    }
}
