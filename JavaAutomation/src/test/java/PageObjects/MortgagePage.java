package PageObjects;

import Helpers.GeneralHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Yurii Oliinyk on 12.10.2017.
 */
public class MortgagePage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using="//div[@class='light-grey-tiles tile-icon icone-calculateur margin-bottom-10 padding-10 padding-bottom-20']/a[@href='/mortgage-payment-calculator']")
    private WebElement CalculateYourPaymentBtn;

    ///<summary>
    /// Method helps user to get to MortgagePaymentCalculator page
    ///</summary>
    public void GoToMortgagePaymentCalculatorPage()
    {
        GeneralHelper.WaitClickableElementByXPath("//div[@class='light-grey-tiles tile-icon icone-calculateur margin-bottom-10 padding-10 padding-bottom-20']/a[@href='/mortgage-payment-calculator']"); //Wait until CalculateYourPayment button will be clickable
        CalculateYourPaymentBtn.click();
    }

    public MortgagePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
