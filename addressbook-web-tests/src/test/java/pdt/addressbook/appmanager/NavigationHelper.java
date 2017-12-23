package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by rb on 12/10/17.
 */
public class NavigationHelper extends BaseHelper {
    public NavigationHelper(WebDriver wd) {
       super(wd);
    }
    public void goToGroupPage() {
        click(By.linkText("groups"));
    }

}