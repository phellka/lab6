package convert.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import core.BaseSeleniumPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import readProperties.ConfigProvider;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class settingsResetPage extends BaseSeleniumPage{
    @FindBy(css = "#UrlInputArea > div.inline > button:nth-child(1)")
    private WebElement buttonSettings;

    @FindBy(css = "#textHeader")
    private WebElement textHead;


    @FindBy(css = "#OptionArea > div.f_center > button.btn_reset_setting")
    private WebElement buttonReset;


    private String successMessageexpth = "#successMessage";

    private String textHeadString = "111";

    public settingsResetPage(){
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public boolean resetSettings(){
        buttonSettings.click();
        textHead.sendKeys(textHeadString);

        driver.navigate().refresh();

        buttonSettings.click();
        buttonReset.click();

        try{
            driver.findElements(By.xpath(successMessageexpth));
        }
        catch(Exception ex){
            System.out.println("No message of success operation");
            return false;
        }

        driver.navigate().refresh();
        buttonSettings.click();

        WebElement waitElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#textHeader")));

        if (!Objects.equals(textHead.getAttribute("value"), ""))
            return false;
        return true;
    }
}
