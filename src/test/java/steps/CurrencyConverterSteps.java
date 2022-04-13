package steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.omg.CORBA.portable.ApplicationException;
import org.openqa.selenium.Keys;
import utils.Logger;

public class CurrencyConverterSteps extends CommonSteps{

    private Logger log=new Logger(CurrencyConverterSteps.class);

    @Steps
    CurrencyConverterPage currencyConverterPage;

    /**
     * This method is used to launch browser and accept cookie window
     * @param portal
     * @return
     */
    public Boolean launchApplication(String portal){

        log.INFO("Open application url");
        String url=getValueFromEnvironmentVariable("webdriver.base.url");
        Serenity.setSessionVariable("url").to(url);
        openUrl(url);
        maximize();
        waitABit(2000);
        currencyConverterPage.btn_AcceptOnConsentBanner.click();
        return currencyConverterPage.lbl_HeaderOfPage.getText().equalsIgnoreCase(portal);
    }

    /**
     * This method is used to enter amount which needs to be converted
     * @param amount
     */
    public void enterCurrencyAmountToBeConverted(String amount){

        currencyConverterPage.tbx_AmountField.clear();
        currencyConverterPage.tbx_AmountField.sendKeys(amount);
        currencyConverterPage.tbx_AmountField.sendKeys(Keys.TAB);
    }

    /**
     * Method is used to insert value in from field and close the promotional window
     * @param currency
     */
    public void enterFromCurrencyNameToBeConverted(String currency){

        WebElementFacade elementFacade=currencyConverterPage.tbx_FromField;
        elementFacade.clear();
        elementFacade.sendKeys(currency);
        elementFacade.sendKeys(Keys.ENTER);
        waitABit(3000);
        if(currencyConverterPage.btn_CloseOnPromotionalBanner.isDisplayed()){
            currencyConverterPage.btn_CloseOnPromotionalBanner.click();
        }
        waitABit(2000);
    }

    /**
     * Method is used to enter To currency field
     * @param currency
     */
    public void enterFinalCurrencyToWhichAmountNeedsToBeConverted(String currency){

        WebElementFacade elementFacade=currencyConverterPage.tbx_ToField;
        elementFacade.clear();
        elementFacade.sendKeys(currency);
        elementFacade.sendKeys(Keys.ENTER);
        waitABit(1000);
        elementFacade.sendKeys(Keys.TAB);
      }

    /**
     * Method is used to click on convert button
      * @param buttonName
     */
    public void clickOnConvertButton(String buttonName){

        switch (buttonName.toLowerCase()){
            case "convert":
                currencyConverterPage.btn_Convert.click();
                break;
            default:
                log.ERROR("Matching case not found");
        }
    }

    /**
     * Method validates the from value after convert button is clicked
     * @param fromValue
     * @return
     */
    public Boolean verifyFromCurrencyAmountValue(String fromValue){

        return verifyTextDisplayedOnPage(currencyConverterPage.lbl_FromCurrency,fromValue);
    }

    /**
     * Method validates the To value after convert button is clicked
     * @param toValue
     * @return
     */
    public Boolean verifyToCurrencyAmountValue(String toValue){

        String actualValue=Serenity.sessionVariableCalled(toValue);
        return verifyTextDisplayedOnPage(currencyConverterPage.lbl_ToCurrency,actualValue);
    }

    /**
     * Method validates the from currency displayed against real time information with date and time
     * @param fromValueRealTime
     * @return
     */
    public Boolean verifyFromRealTimeCurrencyValue(String fromValueRealTime){

        return verifyTextDisplayedOnPage(currencyConverterPage.lbl_FromCurrencyLiveText,fromValueRealTime);
    }

    /**
     * Method validates the to currency displayed against real time information with date and time
     * @param toValueRealTime
     * @return
     */
    public Boolean verifyToRealTimeCurrencyValue(String toValueRealTime){

        return verifyTextDisplayedOnPage(currencyConverterPage.lbl_ToCurrencyLiveText,toValueRealTime);
    }

    /**
     * Method set the converted currency displayed in conversion table in session variable( It keeps on changing every new instance)
     * @param sessionVariable
     */
    public void noteConvertedValueFromConversionTable(String sessionVariable){

        Serenity.setSessionVariable(sessionVariable).to(currencyConverterPage.val_ConvertionValue.getText().substring(0,6));
    }

    /**
     * Method verifies the error message displayed under amount field
     * @param errorMessage
     * @return
     */
    public Boolean verifyErrorMessageDisplayed(String errorMessage){

        return currencyConverterPage.lbl_errorMessage.getText().equalsIgnoreCase(errorMessage);
    }

    /**
     * Method is used to close the browser
     */
    public void closeTheBrowser(){

        getDriver().close();
        getDriver().quit();
    }

    /**
     * Method multiplies the currency value and then amount entered by user and verifies the result
     * @param sessionVariable
     * @param amount
     * @param currency
     */
    public void noteConvertedValue(String sessionVariable, String amount, String currency){

        Double value1=Double.valueOf(amount);
        Double value2=Double.valueOf(Serenity.sessionVariableCalled(currency));
        String result=String.valueOf(value1*value2);
        Serenity.setSessionVariable(sessionVariable).to(result.substring(0,7));
    }

    public void noteConversionBaseValue(String sessionVariable){

        String element=currencyConverterPage.lbl_conversionValue.getText();
        String value=element.split("=")[1].trim().split(" ")[0].trim();
        Serenity.setSessionVariable(sessionVariable).to(value);
    }

}
