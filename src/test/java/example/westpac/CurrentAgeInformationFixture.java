package example.westpac;

import org.concordion.cubano.template.driver.ui.westpac.MainPage;
import org.concordion.cubano.template.framework.CubanoDemoBrowserFixture;

public class CurrentAgeInformationFixture extends CubanoDemoBrowserFixture {
    public String currentAgeInformation() throws Exception {

        return MainPage.open(this)
                .gotoKiwisaver()
                .gotoCalculator()
                .gotoRetirementCalculator()
                .getCurrentAgeInformation();
    }
}
