package example.westpac;

import org.concordion.cubano.template.driver.ui.westpac.MainPage;
import org.concordion.cubano.template.driver.ui.westpac.RetirementCalculatorPage;
import org.concordion.cubano.template.framework.CubanoDemoBrowserFixture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvestmentCalculatorFixture extends CubanoDemoBrowserFixture {

    private static final Logger log = LoggerFactory.getLogger(InvestmentCalculatorFixture.class);

    public void gotoCalculator() {

        RetirementCalculatorPage retire = MainPage.open(this)
                .gotoKiwisaver()
                .gotoCalculator()
                .gotoRetirementCalculator();

    }

    public String calculateGoalsRequirement(String age,
                                            String employmentStatus,
                                            String salary,
                                            String percent,
                                            String pir,
                                            String balance,
                                            String contribution,
                                            String frequency,
                                            String profile,
                                            String goal) throws Exception {




        log.info(" ------------------------------------");
        log.info(" New Scenario Starts Here: ");
        log.info(" ------------------------------------");
        log.info(" Refreshing Calculator Page ");

        RetirementCalculatorPage retire = new RetirementCalculatorPage(this);
        getBrowser().getDriver().navigate().refresh();

        log.info(" Calculating Result ");
        String test = retire.setValues(age, employmentStatus, salary, percent,
                pir, balance, contribution, frequency, profile, goal);

        return test;
    }

}
