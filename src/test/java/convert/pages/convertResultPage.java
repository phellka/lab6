package convert.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import core.BaseSeleniumPage;

public class convertResultPage extends BaseSeleniumPage{
    @FindBy(css = "#container > section.completed > div.complete_box")
    private WebElement completeBox;

    public convertResultPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean checkComplete(){
        return completeBox != null;
    }
}
