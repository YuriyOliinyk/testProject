package PageObjects;

import BrowserInit.BrowserInitializing;
import Helpers.GeneralHelper;
import com.google.errorprone.annotations.Var;
import javafx.scene.web.WebView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class MortgagePaymentCalculatorPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "PrixPropriete")
    private WebElement purchasePriceInput;

    @FindBy(how = How.CSS, using = "div[class='slider-track']")
    private WebElement slider1;

    @FindBy(how = How.ID, using = "PrixProprietePlus")
    private WebElement buttonOfFirstSlider;

    @FindBy(how = How.ID, using = "MiseDeFond")
    private WebElement downPaymentInput;

    @FindBy(how = How.CSS, using = "div[class='slider-track']")
    private WebElement slider2;

    @FindBy(how = How.ID, using = "MiseDeFondPlus")
    private WebElement buttonOfSecondSlider;

    @FindBy(how = How.XPATH, using = "//form[@id='form_calculateur_versements']/div[4]/div/div/div[@class='selectric-items']/div/ul")
    private WebElement amortizationDropDown;

    @FindBy(how = How.XPATH, using = "//form[@id='form_calculateur_versements']/div[4]/div/div/div[@class='selectric']/b")
    private WebElement expandAmortizationDropDown;

    @FindBy(how = How.XPATH, using = "//form[@id='form_calculateur_versements']/div[5]/div[@class='selectric-items']/div/ul")
    private WebElement frequencyDropDown;

    @FindBy(how = How.XPATH, using = "//form[@id='form_calculateur_versements']/div[5]/div[@class='selectric']/b")
    private WebElement expandFrequencyDropDown;

    @FindBy(how = How.ID, using = "TauxInteret")
    private WebElement interestRateInput;

    @FindBy(how = How.ID, using = "btn_calculer")
    private WebElement calculateBtn;

    @FindBy(how = How.ID, using = "paiement-resultats")
    private WebElement calculationResult;


    public WebElement getSlider1() {
        return slider1;
    }

    private WebElement getDownPaymentInput() {
        return downPaymentInput;
    }

    private WebElement getCalculationResult() {
        return calculationResult;
    }


    ///<summary>
    /// Method gets value from purchase price input
    ///</summary>
    public int GetPriceValue() {
        String price = purchasePriceInput.getAttribute("value");
        int priceValue = Integer.parseInt(price);
        return priceValue;
    }


    ///<summary>
    /// Method is used to move slider using + button
    ///</summary>
    public void MoveAnySliderUsingPlusButton(int clicks, int slider) {
        for (int k = 0; k < clicks; k++) {
            switch (slider) {
                //Case 1 is used to work with first slider
                case 1:
                    buttonOfFirstSlider.click();
                    GeneralHelper.DoSmallDelay();
                    break;
                //Case 2 is used to work with second slider
                case 2:
                    buttonOfSecondSlider.click();
                    GeneralHelper.DoSmallDelay();
                    break;
            }
        }
    }

    ///<summary>
    /// Method is used to select needed years in dropdown Amortization
    ///</summary>
    public void SelectNeededAmortization(int years) {
        WebElement option = amortizationDropDown.findElement(By.tagName("li"));
        int countAllOptions = amortizationDropDown.findElements(By.tagName("li")).size();
        for (int k = 0; k < countAllOptions; k++) {
            String optionValue = amortizationDropDown.findElements(By.tagName("li")).get(k).getAttribute("innerHTML").trim();
            String value = Integer.toString(years) + " years";
            if (optionValue.equals(value)) {
                expandAmortizationDropDown.click();
                WebElement neededOption = amortizationDropDown.findElements(By.tagName("li")).get(k);
                neededOption.click();
                break;
            }

        }
    }


    ///<summary>
    /// Method is used to select needed option in dropdown Payment frequency
    ///</summary>
    public void SelectNeededFrequency(String frequency) {
        WebElement option = frequencyDropDown.findElement(By.tagName("li"));
        int countAllOptions = frequencyDropDown.findElements(By.tagName("li")).size();
        for (int k = 0; k < countAllOptions; k++) {
            String optionValue = frequencyDropDown.findElements(By.tagName("li")).get(k).getAttribute("innerHTML").trim();
            if (optionValue.equals(frequency)) {
                expandFrequencyDropDown.click();
                WebElement neededOption = frequencyDropDown.findElements(By.tagName("li")).get(k);
                neededOption.click();
                break;
            }

        }
    }

    ///<summary>
    /// Method helps to enter value in Interest rate input
    ///</summary>
    public void EnterValueInInterestRate(String value) {
        interestRateInput.clear();
        interestRateInput.sendKeys(value);
    }

    ///<summary>
    /// Method clicks on Calculate button
    ///</summary>
    public void ClickCalculateButton() {
        calculateBtn.click();
    }

    ///<summary>
    /// Method gets calculate result
    ///</summary>
    public String GetCalculationResult() {
        String calculationResult = getCalculationResult().getText();
        return calculationResult;
    }


    ///<summary>
    /// Method gets value from Down payment input
    ///</summary>
    public int GetDownPayment() {
        String downPayment = getDownPaymentInput().getAttribute("value");
        int downPaymentValue = Integer.parseInt(downPayment);
        return downPaymentValue;

    }


    public MortgagePaymentCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
