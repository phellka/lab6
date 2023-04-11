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

    public class settingsPage extends BaseSeleniumPage{
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

        @FindBy(css = "#OptionArea > div.f_center > button.btn_reset_setting")
        private WebElement buttonReset;

        @FindBy(css = "#textPageZoom")
        private WebElement zoom;

        private String messageSuccessCss = "#success";

        public settingsPage(){
            driver.get(ConfigProvider.URl);
            PageFactory.initElements(driver, this);
        }

        public void openSettings(){
            buttonSettings.click();
        }

        public void selectSet(int id){
            Select sel = new Select(select);
            sel.selectByIndex(id);
        }

        public void headerSet(String text){
            textHead.sendKeys(text);
        }

        public void footerSet(String text){
            textFoot.sendKeys(text);
        }

        public void gorizSet(){
            goriz.click();
        }

        public void saveSettings(){
            buttonSave.click();
        }

        public void resetSettings() {
            buttonReset.click();
        }

        public void refreshPage(){
            driver.navigate().refresh();
        }

        public boolean checkSelect(String text){
            Select sel = new Select(select);
            if(!Objects.equals(sel.getFirstSelectedOption().getText(), text))
                return false;
            return true;
        }

        public boolean checkHead(String text){
            if (!Objects.equals(textHead.getAttribute("value"), text))
                return false;
            return true;
        }

        public boolean checkFoot(String text){
            if (!Objects.equals(textFoot.getAttribute("value"), text))
                return false;
            return true;
        }

        public boolean checkGorizSelect(){
            if (!goriz.isSelected())
                return false;
            return true;
        }

        public void clearZoom(){
            zoom.clear();
        }

        public boolean checkZoom(String text){
            if (!Objects.equals(zoom.getAttribute("value"), text))
                return false;
            return true;
        }

        public boolean checkSuccessMessage(){
            try{
                driver.findElements(By.xpath(messageSuccessCss));
            }
            catch(Exception ex){
                System.out.println("No message of success operation");
                return false;
            }
            return true;
        }
    }
