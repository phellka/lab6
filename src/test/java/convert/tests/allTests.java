package convert.tests;

import core.BaseSeleniumTest;
import org.junit.Test;
import convert.pages.*;

public class allTests extends BaseSeleniumTest{
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

    @Test
    public void saveSettingsTest(){
        assert new settingsSavePage().saveSettings();
    }
    @Test
    public void resetSettingsTest(){
        assert new settingsResetPage().resetSettings();
    }
    @Test
    public void saveEmptySettingsTest(){
        assert new settingsSaveEmptyPage().saveEmptySettings();
    }
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
