package convert.tests;

import core.BaseSeleniumTest;
import org.junit.Test;
import convert.pages.*;
import org.openqa.selenium.WebElement;
import java.util.List;

public class convertTests extends BaseSeleniumTest{
    String goodAddress = "https://webtopdf.com/ru/";
    String badAddress = "https://weeebtopdf.com/ru/";

    @Test
    public void pdfConvert() {
        convertToPdfPage cnvrtPage = new convertToPdfPage();
        cnvrtPage.setAddress(goodAddress);
        convertResultPage converRes = cnvrtPage.convertToPdf();
        assert converRes.checkComplete();
    }

    @Test
    public void jpgConvert() {
        convertToJPG cnvrtPage = new convertToJPG();
        cnvrtPage.setAddress(goodAddress);
        convertResultPage converRes = cnvrtPage.convertToJPG();
        assert converRes.checkComplete();
    }

    @Test
    public void screanConvert() {
        convertToScrean cnvrtPage = new convertToScrean();
        cnvrtPage.setAddress(goodAddress);
        convertResultPage converRes = cnvrtPage.convertToScrean();
        assert converRes.checkComplete();
    }

    @Test
    public void wrongConvert(){
        converWrong cnvrtPage = new converWrong();
        cnvrtPage.setAddress(goodAddress);
        assert cnvrtPage.convertWrong();
    }
}
