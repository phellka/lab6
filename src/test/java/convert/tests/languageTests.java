package convert.tests;

import core.BaseSeleniumTest;
import org.junit.Test;
import convert.pages.*;
import org.openqa.selenium.WebElement;
import java.util.List;

public class languageTests extends BaseSeleniumTest{
    @Test
    public void languageTest(){
        boolean result = true;
        languagePage lanPage = new languagePage();
        lanPage.setRu();
        result = result && lanPage.ruCheck();
        lanPage.setEn();
        result = result && lanPage.enCheck();
        lanPage.setFr();
        result = result && lanPage.frCheck();
        assert result;
    }
}
