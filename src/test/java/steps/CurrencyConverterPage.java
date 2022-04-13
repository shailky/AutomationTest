package steps;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CurrencyConverterPage extends PageObject {

    @FindBy(xpath = "//h1[contains(@class,'heading__Heading1')]")
    public WebElementFacade lbl_HeaderOfPage;

    @FindBy(xpath = "//label[text()='Amount']/following-sibling::div[1]/span/input")
    public WebElementFacade tbx_AmountField;

    @FindBy(id = "midmarketFromCurrency")
    public WebElementFacade tbx_FromField;

    @FindBy(id = "midmarketToCurrency")
    public WebElementFacade tbx_ToField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElementFacade btn_Convert;

    @FindBy(xpath = "//div[contains(@class,'currency-converter__GridContainer')]/following-sibling::div/div[1]/p[1]")
    public WebElementFacade lbl_FromCurrency;

    @FindBy(xpath = "//div[contains(@class,'currency-converter__GridContainer')]/following-sibling::div/div[1]/p[2]")
    public WebElementFacade lbl_ToCurrency;

    @FindBy(xpath = "//div[contains(@class,'result__LiveSubText')]/a[1]")
    public WebElementFacade lbl_FromCurrencyLiveText;

    @FindBy(xpath = "//div[contains(@class,'result__LiveSubText')]/a[2]")
    public WebElementFacade lbl_ToCurrencyLiveText;

    @FindBy(xpath="//section//h2[contains(text(),'Allow optional cookies?')]")
    public WebElementFacade lbl_HeaderOfConsentBanner;

    @FindBy(xpath="//button[text()='Accept']")
    public WebElementFacade btn_AcceptOnConsentBanner;

    @FindBy(xpath="//button[@aria-label='close']")
    public WebElementFacade btn_CloseOnPromotionalBanner;

    @FindBy(xpath="//div[@class='currency-conversion-tables__TablesContainer-sc-3fg8ob-0 dpMxOr']/div[1]/table//tbody/tr[1]/td[2]")
    public WebElementFacade val_ConvertionValue;

    @FindBy(xpath="//label[text()='Amount']/following-sibling::div[@aria-live='assertive']")
    public WebElementFacade lbl_errorMessage;

    @FindBy(xpath="//div[@class='unit-rates___StyledDiv-sc-1dk593y-0 dEqdnx']/p[1]")
    public WebElementFacade lbl_conversionValue;

    public String optionsFromValues="//*[(contains(@class,'converterform-dropdown__option') or contains(@class,'ListboxOption')) and contains(.,'REPLACE_TEXT')]";

}
