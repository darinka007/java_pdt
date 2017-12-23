package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by rb on 12/10/17.
 */
public class BaseHelper {
    protected WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    protected void typeFieldValue(By locator, String text) {
        if(text !=null){
            String existingText = wd.findElement(locator).getAttribute("value1");
        if(!equals(existingText)) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
        }
    }

    protected void click(By locator) {
        locator.findElement(wd).click();
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void submitDeletionContact() {
        wd.switchTo().alert().accept();
    }


}