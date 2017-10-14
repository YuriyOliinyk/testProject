package PageObjects;
import Helpers.GeneralHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



/**
 * Created by Yurii Oliinyk on 12.10.2017.
 */
public class HomePage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using="a[href='/individuals/pret']")
    private WebElement LoanLink;

    @FindBy(how = How.CSS, using="a[href='/mortgage']")
    private WebElement MortagesLink;

    ///<summary>
    /// Method helps user to get to Mortage page
    ///</summary>
    public void GoToMortagePage()
    {
        GeneralHelper.WaitClickableElementByCssSelector("a[href='/individuals/pret']"); //Wait until Loan link will be clickable
        LoanLink.click();
        GeneralHelper.WaitClickableElementByCssSelector("a[href='/mortgage']"); //Wait until Mortages link will be clickable
        MortagesLink.click();
    }

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
