package convert.tests;

import core.BaseSeleniumTest;
import org.junit.Test;
import convert.pages.*;

import java.util.concurrent.TimeUnit;

public class settingsTest extends BaseSeleniumTest{
    private String textHeadString = "111";
    private String textFootString = "222";
    private int idSelect = 1;
    private String selectString = "A0 (841 x 1189 mm, 33.1 x 46.8 in)";
    private String zoomOriginalString = "100";

    @Test
    public void saveSettingsTest(){
        boolean result = true;
        settingsPage setPage = new settingsPage();
        setPage.openSettings();
        setPage.selectSet(idSelect);
        setPage.footerSet(textFootString);
        setPage.headerSet(textHeadString);
        setPage.gorizSet();
        setPage.saveSettings();
        setPage.refreshPage();
        setPage.openSettings();
        try {
            Thread.sleep(3000);
        }
        catch (Exception ex){}
        result = result && setPage.checkFoot(textFootString);
        result = result && setPage.checkHead(textHeadString);
        result = result && setPage.checkGorizSelect();
        result = result && setPage.checkSelect(selectString);
        assert result;
    }
    @Test
    public void resetSettingsTest(){
        settingsPage setPage = new settingsPage();
        setPage.openSettings();
        setPage.headerSet(textHeadString);
        setPage.saveSettings();
        setPage.refreshPage();
        setPage.openSettings();
        setPage.resetSettings();
        setPage.refreshPage();
        setPage.openSettings();
        try {
            Thread.sleep(3000);
        }
        catch (Exception ex){}
        boolean result = setPage.checkSuccessMessage();
        assert result && setPage.checkHead("");
    }
    @Test
    public void saveEmptySettingsTest(){
        settingsPage setPage = new settingsPage();
        setPage.openSettings();
        setPage.clearZoom();
        setPage.saveSettings();
        setPage.refreshPage();
        setPage.openSettings();
        try {
            Thread.sleep(3000);
        }
        catch (Exception ex){}
        assert setPage.checkZoom(zoomOriginalString);
    }
}
