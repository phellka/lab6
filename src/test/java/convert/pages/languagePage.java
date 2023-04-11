package convert.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import core.BaseSeleniumPage;
import readProperties.ConfigProvider;

import java.util.Objects;

public class languagePage extends BaseSeleniumPage{
    @FindBy(css = "#wrap > footer > div.web_footer > ul > li.language > label")
    private WebElement chose;

    @FindBy(css = "#ru")
    private WebElement ru;

    @FindBy(css = "#fr")
    private WebElement fr;

    @FindBy(css = "#en")
    private WebElement en;

    @FindBy(css = "#container > section.top_AREA_webpage > div.webpage_top > h1")
    private WebElement text;

    private String ruString = "Перевести сайт в PDF";
    private String frString = "Page Web en PDF";
    private String enString = "Webpage to PDF";


    public languagePage(){
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public void setRu(){
        chose.click();
        ru.click();
    }

    public boolean ruCheck(){
        if (!Objects.equals(text.getText(), ruString)){
            return false;
        }
        return true;
    }

    public void setEn(){
        chose.click();
        en.click();
    }

    public boolean enCheck(){
        if (!Objects.equals(text.getText(), enString)){
            return false;
        }
        return true;
    }

    public void setFr(){
        chose.click();
        fr.click();
    }

    public boolean frCheck(){
        if (!Objects.equals(text.getText(), frString)){
            return false;
        }
        return true;
    }
}
