package steps;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.UnsupportedDriverException;
import org.junit.runner.RunWith;
import org.omg.CORBA.portable.ApplicationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonSteps extends ScenarioSteps {

    WebDriver driver;
    EnvironmentVariables variables;

    @Steps
    CurrencyConverterPage currencyConverterPage;

    /**
     * This method is used to set webdriver instance if serenity is not working with project configuration.
     * Use this method in launching step method if serenity doesn't work
     */
    public void setup() {

        DesiredCapabilities capabilities;
        variables = SystemEnvironmentVariables.createEnvironmentVariables();
        switch (variables.getProperty("webdriver.driver").toLowerCase()) {
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
                driver=new ChromeDriver();
                break;
            default:
                throw new UnsupportedDriverException("Browser configured at SERENITY.PROPERTIES file is INVALID. Supported browsers are firefox, chrome, edge and iexplorer");
        }
    }

    /**
     * Method To open Url
     *
     * @param url
     */
    public void openUrl(String url) {

        getDriver().navigate().to(url);
        getDriver().navigate().refresh();
    }

    /**
     * Method to maximise browser window
     */
    public void maximize() {

        getDriver().manage().window().maximize();
    }

    /**
     * Function to get value from environment variable
     *
     * @param envVar whose value to be get
     * @return value
     */

    public String getValueFromEnvironmentVariable(String envVar) {
        String value = SystemEnvironmentVariables.createEnvironmentVariables().getProperty(envVar);
        return value;
    }

    /**
     * Method to verify text displayed on screen
     * @param elementFacade
     * @param text
     * @return
     */
    public Boolean verifyTextDisplayedOnPage(WebElementFacade elementFacade, String text){

        return elementFacade.getText().contains(text);
    }










}
