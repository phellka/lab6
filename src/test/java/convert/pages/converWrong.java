package convert.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import core.BaseSeleniumPage;

import java.util.Objects;

public class converWrong extends BaseSeleniumPage{
    @FindBy(css = "#web_topmenu > ul > li:nth-child(1) > a")
    private WebElement buttonToPdf;

    @FindBy(css = "#textUrl")
    private WebElement inputAddress;

    @FindBy(css = "#btnConvert")
    private WebElement buttonConvert;

    @FindBy(css = "#container > section")
    private WebElement errorElement;

    public converWrong(){
        driver.get("https://webtopdf.com/ru/");
        PageFactory.initElements(driver, this);
    }

    public void setAddress(String address){
        inputAddress.sendKeys(address);
    }

    public boolean convertWrong(){
        buttonConvert.click();
        String url = driver.getCurrentUrl();
        while(Objects.equals(url, driver.getCurrentUrl())){ }
        return errorElement != null;
    }
}
