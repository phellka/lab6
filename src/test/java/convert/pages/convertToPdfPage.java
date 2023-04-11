package convert.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import core.BaseSeleniumPage;
import readProperties.ConfigProvider;

import java.util.Objects;

public class convertToPdfPage extends BaseSeleniumPage{
    @FindBy(css = "#web_topmenu > ul > li:nth-child(1) > a")
    private WebElement buttonToPdf;

    @FindBy(css = "#textUrl")
    private WebElement inputAddress;

    @FindBy(css = "#btnConvert")
    private WebElement buttonConvert;


    public convertToPdfPage(){
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public void setAddress(String address){
        inputAddress.sendKeys(address);
    }

    public convertResultPage convertToPdf(){
        buttonConvert.click();
        String url = driver.getCurrentUrl();
        while(Objects.equals(url, driver.getCurrentUrl())){  }
        return new convertResultPage();
    }
}
