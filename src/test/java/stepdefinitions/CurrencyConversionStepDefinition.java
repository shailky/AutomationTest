package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.CurrencyConverterSteps;
import utils.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyConversionStepDefinition {

    private Logger log=new Logger(CurrencyConverterSteps.class);

    @Steps
    CurrencyConverterSteps currencyConverterSteps;

    @Given("^I am on \"([^\"]*)\" landing page$")
    public void i_am_on_something_landing_page(String portalName) {

        log.INFO("I am on "+portalName+"Landing page");
        assertThat(currencyConverterSteps.launchApplication(portalName)).isTrue();
    }

    @When("^I enter amount to be converted as \"([^\"]*)\" on 'Xe Converter' Page$")
    public void i_enter_amount_to_be_converted_as_something_on_xe_converter_page(String currencyAmount) {

        log.INFO("I enter"+currencyAmount+" on Xe converter Page");
        currencyConverterSteps.enterCurrencyAmountToBeConverted(currencyAmount);
    }

    @And("^I enter from currency as \"([^\"]*)\" on 'Xe Converter' Page$")
    public void i_enter_from_currency_as_something_on_xe_converter_page(String fromCurrency)  {

        log.INFO("I enter from currency "+fromCurrency+" On Converter page");
        currencyConverterSteps.enterFromCurrencyNameToBeConverted(fromCurrency);

    }

    @And("^I enter to currency as \"([^\"]*)\" on 'Xe Converter' Page$")
    public void i_enter_to_currency_as_something_on_xe_converter_page(String toCurrency)  {

        log.INFO("I enter from currency "+toCurrency+" On Converter page");
        currencyConverterSteps.enterFinalCurrencyToWhichAmountNeedsToBeConverted(toCurrency);
    }

    @And("^I click on \"([^\"]*)\" button on 'Xe Converter' Page$")
    public void i_click_on_something_button_on_xe_converter_page(String buttonName)  {

        log.INFO("I click on"+buttonName+" button On Converter Page");
        currencyConverterSteps.clickOnConvertButton(buttonName);
    }


    @Then("^I verify from currency amount is displayed as \"([^\"]*)\" on 'Xe Converter' Page$")
    public void i_verify_from_currency_amount_is_displayed_as_something_on_xe_converter_page(String fromCurrency)  {

        log.INFO("I verify from currency amount"+fromCurrency+"Original value entered");
        assertThat(currencyConverterSteps.verifyFromCurrencyAmountValue(fromCurrency)).isTrue();
    }

    @And("^I verify To currency amount is displayed as \"([^\"]*)\" on 'Xe Converter' Page$")
    public void i_verify_to_currency_amount_is_displayed_as_something_on_xe_converter_page(String toCurrency)  {

        log.INFO("I verify To currency amount"+toCurrency+"changed value after currency change");
        assertThat(currencyConverterSteps.verifyToCurrencyAmountValue(toCurrency)).isTrue();
    }


    @Then("^I verify from currency is displayed as \"([^\"]*)\" under live conversion value on 'Xe Converter' Page$")
    public void i_verify_from_currency_is_displayed_as_something_under_live_conversion_value_on_xe_converter_page(String realTimeFromCurrency) {

        log.INFO("I verify from currency"+realTimeFromCurrency+" displayed against current date time");
        assertThat(currencyConverterSteps.verifyFromRealTimeCurrencyValue(realTimeFromCurrency)).isTrue();
    }


    @And("^I verify To currency is displayed as \"([^\"]*)\" under live conversion value on 'Xe Converter' Page$")
    public void i_verify_to_currency_is_displayed_as_something_under_live_conversion_value_on_xe_converter_page(String realTimeToCurrency)  {

        log.INFO("I verify To currency"+realTimeToCurrency+" displayed against current date time");
        assertThat(currencyConverterSteps.verifyToRealTimeCurrencyValue(realTimeToCurrency)).isTrue();
    }

    @And("^I note \"([^\"]*)\" converted value from conversion table$")
    public void iNoteConvertedValueFromConversionTable(String sessionVariable){

        log.INFO("I note converted value");
        currencyConverterSteps.noteConvertedValueFromConversionTable(sessionVariable);
    }

    @And("^I close the application$")
    public void iCloseTheApplication(){

        log.INFO("I close the application");
        currencyConverterSteps.closeTheBrowser();
    }

}
