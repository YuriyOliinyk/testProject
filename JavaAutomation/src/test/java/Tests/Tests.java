package Tests;

import BrowserInit.BrowserInitializing;
import Helpers.GeneralHelper;
import PageObjects.HomePage;
import PageObjects.MortgagePage;
import PageObjects.MortgagePaymentCalculatorPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by Yurii Oliinyk on 12.10.2017.
 */
public class Tests {

    @BeforeMethod
    public void Initialize()
    {
        BrowserInitializing.GetBrowser(1);
        BrowserInitializing.LoadApplication();
        HomePage homePage = new HomePage(BrowserInitializing.getDriver());
        MortgagePage mortgagePage = new MortgagePage(BrowserInitializing.getDriver());
        homePage.GoToMortagePage();
        mortgagePage.GoToMortgagePaymentCalculatorPage();
    }



    @Test
    ///<summary>
    /// User moves slider right and check is value is increase in purchase price input
    ///</summary>
    public void ValidatePurchaseSlider()
    {
        MortgagePaymentCalculatorPage paymentCalculator = new MortgagePaymentCalculatorPage(BrowserInitializing.getDriver());
        Actions move = new Actions(BrowserInitializing.getDriver());
        int defaultValue = 0;
        WebElement slider = paymentCalculator.getSlider1();
        for(int k=10; k<=100; k=k+10)
        {
            move.moveToElement(slider, (slider.getSize().getWidth()*k/100), 0).click().build().perform();
            int price = paymentCalculator.GetPriceValue();
            Assert.assertTrue(price>defaultValue);
            defaultValue = price;
        }


    }

    @Test
    ///<summary>
    /// User checks calculation result
    /// Steps:
    /// 1) First slider :: clicks on + button 2 times to get 500K
    /// 2) Second slider :: clicks on + button 1 times to get 100K
    /// 3) Select 15 years option
    /// 4) Select weekly option
    /// 5) Enter 5 value
    /// 6) Click Calculate button
    /// 5) Verify if value is ""
    ///</summary>
    public void Validate()
    {
        MortgagePaymentCalculatorPage paymentCalculator = new MortgagePaymentCalculatorPage(BrowserInitializing.getDriver());
        paymentCalculator.MoveAnySliderUsingPlusButton(2,1); //User clicks on + button 2 times to get 500K
        paymentCalculator.MoveAnySliderUsingPlusButton(1,2);
        paymentCalculator.SelectNeededAmortization(15);
        paymentCalculator.SelectNeededFrequency("weekly");
        paymentCalculator.EnterValueInInterestRate("5");
        paymentCalculator.ClickCalculateButton();
        GeneralHelper.WaitVisibleElementByID("paiement-resultats");
        String calculationResult = paymentCalculator.GetCalculationResult().substring(2);
        Assert.assertEquals("726.35", calculationResult);
    }

    @AfterMethod
    public void EndTest()
    {
        BrowserInitializing.CloseAllDriver();
    }
}