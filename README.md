# Westpac Test Project

This project uses the [Cubano DFramework](https://github.com/concordion/cubano) as its underlying framework.

To get the demo project working, follow the Section below > [Set up and run this project](#set-up-and-run-this-project).

Further Information on this framework can  be found at the following:
* the [Cubano documentation](https://concordion.org/cubano) and in particular the [Cubano Framework Guide](https://concordion.org/cubano/framework)
* the [Concordion documentation](https://concordion.org/) and especially the [Concordion Hints and Tips page](https://concordion.org/technique/java/markdown/)

## Features
* Java Based
* Integrated Selenium for Web Testing
* Integrated Concordion for beautiful Living Documents

## Set up and run this project  
* Ensure you have a [Git client](https://git-scm.com/downloads) and [Gradle](https://gradle.org/) installed (or use via your IDE or other tools)
* Install [Firefox](https://www.mozilla.org/en-US/firefox/new/).  The default browser used in this demo project is Firefox.
* `cd` to a relevant folder
* `git clone https://github.com/karl-osd/westpac.git` or download and unzip this project
* Import as a Gradle project into your IDE (e.g. for Eclipse, ensure [Buildship](http://www.eclipse.org/buildship) is installed, then File > Import > Gradle > Existing Gradle Project > follow the wizard)

## A note on Browsers
By default this project is set up to use the Firefox browser.

The property `webdriver.browserprovider`, in config.properties controls the default browser (e.g. `webdriver.browserprovider = FirefoxBrowserProvider`).

To modify the default browser, update property `webdriver.browserprovider` in either:
* the config.properties file

Additional `[BrowserName]BrowserProviders` can be found in package `org.concordion.cubano.driver.web.provider.*`. 

Two other important classes to review are:
* `org.concordion.cubano.driver.web.config.WebDriverConfig` > Reads and supplies properties from the config.properties file that is required by the framework
* `org.concordion.cubano.driver.web.provider.LocalBrowserProvider` > Base class for local browser providers.

Further information on browser support and configuration can be found in the [Cubano documentation on Browser Providers](https://concordion.org/cubano/browser/providers)

## To Execute Tests
Concordion fixtures use the JUnit library, with a specialised ConcordionRunner (`@RunWith(ConcordionRunner.class)`).  This annotation is part of the class hierarchy from `ConcordionIndex` or `ConcordionFixture`, which all Fixtures inherit from.

### From an IDE (e.g. Eclipse)
* The following classes should be run as per any standard JUnit fixture:
   * `CurrentAgeInformationFixture` and,  
   * `InvestmentCalculatorFixture`

## Results 
Living Documentation will be available once run as follows:
* file:///tmp/concordion/example/westpac/CurrentAgeInformation.html
* file:///tmp/concordion/example/westpac/InvestmentCalculator.html
