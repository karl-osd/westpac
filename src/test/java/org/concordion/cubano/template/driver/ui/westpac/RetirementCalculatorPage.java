package org.concordion.cubano.template.driver.ui.westpac;

import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.driver.ui.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RetirementCalculatorPage extends PageObject<RetirementCalculatorPage> {
    public RetirementCalculatorPage(BrowserBasedTest test) {
        super(test);
    }

    @FindBy(xpath = "//h1[contains(text(), 'KiwiSaver Retirement Calculator')]")
    private WebElement heading;

    @FindBy(id = "calculator-embed")
    private WebElement calculatorEmbedded;

    @FindBy(tagName = "iframe")
    private WebElement iframe;

    @FindBy(xpath = "//div[contains(@class, 'wpnib-field-current-age')]")
    private WebElement currentAgeRow;

    @FindBy(xpath = "//div[contains(@class, 'wpnib-field-employment-status')]")
    private WebElement employmentStatusRow;

    @FindBy(xpath = "//div[contains(@class, 'wpnib-field-annual-income')]")
    private WebElement salaryWagesRow;

    @FindBy(xpath = "//div[contains(@class, 'wpnib-field-kiwisaver-member-contribution')]")
    private WebElement kiwisaverRateRow;

    @FindBy(xpath = "//div[contains(@class, 'wpnib-field-pir-rate')]")
    private WebElement pirRateRow;

    @FindBy(xpath = "//div[contains(@class, 'wpnib-field-kiwi-saver-balance')]")
    private WebElement kiwiSaverBalanceRow;

    @FindBy(xpath = "//div[contains(@class, 'wpnib-field-voluntary-contributions')]")
    private WebElement voluntaryContributionsRow;

    @FindBy(xpath = "//div[contains(@class, 'wpnib-field-risk-profile')]")
    private WebElement riskProfileRow;

    @FindBy(xpath = "//div[contains(@class, 'wpnib-field-savings-goal')]")
    private WebElement savingsGoalRow;

    @FindBy(xpath = "//span[contains(text(), 'View your KiwiSaver retirement')]")
    private WebElement viewCalculation;

    @FindBy(xpath = "//span[contains(@class, 'result-value')]")
    private WebElement calculatedResult;

    @Override
    public ExpectedCondition<?> pageIsLoaded(Object... params) {

        return ExpectedConditions.visibilityOf(iframe);
        }

    private void switchToIframe() throws Exception {
        //todo fix this mess ....
        Thread.sleep(5000);
        //waitUntilAjaxRequestsCompleted();

        getBrowser().getDriver().switchTo().frame(iframe);
    }

    public String getCurrentAgeInformation() throws Exception {
        switchToIframe();
        currentAgeRow.findElement(By.xpath("*//button")).click();
        return currentAgeRow.findElement(By.tagName("p")).getText();

    }

    public void setCurrentAge(String age) {
        currentAgeRow.findElement(By.tagName("input")).sendKeys(age);
    }

    public void setEmploymentStatus(String employmentStatus) {
        employmentStatusRow.findElement(By.xpath("//span[contains(text(), 'Select')]")).click();
        employmentStatusRow.findElement(By.xpath("//span[contains(text(), '" + employmentStatus.trim() + "')]")).click();
    }

    //Dependant on Employment
    public void setSalary(String wages) {
        System.out.println("Salary = '" + wages + "'" );
        if (!wages.contains("null")) {
            salaryWagesRow.findElement(By.tagName("input")).sendKeys(wages);
        }
    }

    //Dependant on Employment
    public void setKiwisaverRate(String percent) {
        if (!percent.contains("null")) {
            kiwisaverRateRow.findElement(By.xpath("//span[contains(text(), '" + percent.trim() + "%')]")).click();
        }

    }

    public void setPirRate(String pirRate) {
        pirRateRow.findElement(By.xpath("//span[contains(text(), 'Select')]")).click();
        pirRateRow.findElement(By.xpath("//span[contains(text(), '" + pirRate.trim() + "%')]")).click();
    }

    //Optional
    public void setKiwiSaverBalance(String amount) {
        if (!amount.contains("null")) {
            kiwiSaverBalanceRow.findElement(By.tagName("input")).sendKeys(amount);
        }

    }

    //Optional
    public void setVoluntaryContributions(String amount, String frequency) {
        if (!amount.contains("null")) {
            voluntaryContributionsRow.findElement(By.tagName("input")).sendKeys(amount);
            voluntaryContributionsRow.findElement(By.xpath("//span[contains(text(), 'Frequency')]")).click();
            voluntaryContributionsRow.findElement(By.xpath("//span[contains(text(), '" + frequency.trim() + "')]")).click();
        }

    }

    public void setRiskProfile(String profile) {
        riskProfileRow.findElement(By.xpath("//span[contains(text(), '" + profile.trim() + "')]")).click();
    }

    //Optional
    public void setSavingsGoal(String goalAmount) {
        if (!goalAmount.contains("null")) {
            savingsGoalRow.findElement(By.tagName("input")).sendKeys(goalAmount);
        }

    }

    public String getCalculatedResult() {
        return calculatedResult.getText().replace("$", "").trim();
    }

    public String setValues(String age, String employ, String wages, String kiwisaveRate, String pirRate,
                          String kiwisaverBalance, String contributions, String frequency,
                          String profile, String goalAmount) throws Exception {

        switchToIframe();
        setCurrentAge(age);
        setEmploymentStatus(employ);

        if (employ.contains("Employed")) {
            setSalary(wages);
            setKiwisaverRate(kiwisaveRate);
        }

        setPirRate(pirRate);
        setKiwiSaverBalance(kiwisaverBalance);
        setVoluntaryContributions(contributions, frequency);
        setRiskProfile(profile);
        setSavingsGoal(goalAmount);

        viewCalculation.click();
        capturePage(calculatedResult);
        return getCalculatedResult();


    }
}
