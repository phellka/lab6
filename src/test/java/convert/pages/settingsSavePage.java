package convert.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import core.BaseSeleniumPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import readProperties.ConfigProvider;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class settingsSavePage extends BaseSeleniumPage{
    @FindBy(css = "#UrlInputArea > div.inline > button:nth-child(1)")
    private WebElement buttonSettings;

    @FindBy(css = "#comboPageSize")
    private WebElement select;

    @FindBy(css = "#textHeader")
    private WebElement textHead;

    @FindBy(css = "#textFooter")
    private WebElement textFoot;

    @FindBy(css = "#OptionArea > div.optpack2 > div.set_line01 > div:nth-child(1) > div > div:nth-child(3) > div:nth-child(3) > div.options_div > label > input")
    private WebElement goriz;

    @FindBy(css = "#OptionArea > div.f_center > button.btn_save_setting")
    private WebElement buttonSave;

    private String textHeadString = "111";
    private String textFootString = "222";
    private String selectString = "A0 (841 x 1189 mm, 33.1 x 46.8 in)";

    public settingsSavePage(){
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public boolean saveSettings(){
        buttonSettings.click();
        Select sel = new Select(select);
        sel.selectByIndex(1);
        textHead.sendKeys(textHeadString);
        textFoot.sendKeys(textFootString);
        goriz.click();
        buttonSave.click();

        driver.navigate().refresh();


        buttonSettings.click();

        WebElement waitElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#textHeader")));

        sel = new Select(select);
        if(!Objects.equals(sel.getFirstSelectedOption().getText(), selectString))
            return false;
        if (!Objects.equals(textHead.getAttribute("value"), textHeadString))
            return false;
        if (!Objects.equals(textFoot.getAttribute("value"), textFootString))
            return false;
        if (!goriz.isSelected())
            return false;
        return true;
    }
}
