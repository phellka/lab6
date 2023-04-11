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

public class settingsSaveEmptyPage extends BaseSeleniumPage{
    @FindBy(css = "#UrlInputArea > div.inline > button:nth-child(1)")
    private WebElement buttonSettings;

    @FindBy(css = "#textPageZoom")
    private WebElement zoom;

    @FindBy(css = "#OptionArea > div.f_center > button.btn_save_setting")
    private WebElement buttonSave;

    private String zoomOriginalString = "100";

    public settingsSaveEmptyPage(){
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public boolean saveEmptySettings(){
        buttonSettings.click();

        zoom.clear();


        buttonSave.click();

        driver.navigate().refresh();


        buttonSettings.click();

        WebElement waitElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#textHeader")));

        if (!Objects.equals(zoom.getAttribute("value"), zoomOriginalString))
            return false;
        return true;
    }
}
