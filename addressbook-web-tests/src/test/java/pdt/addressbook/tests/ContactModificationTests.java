package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.UUID;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModitication() {
        ContactData contact = new ContactData();
        app.getContactHelper().selectContact();
        app.getContactHelper().modifyContact();
        app.getContactHelper().fillContactBirthDate();
        app.getContactHelper().saveContactChanges();

        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Address book updated\n" + "return to home page"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));

    }

    @BeforeMethod
    public void createContactIfDoesNotExist() {
        if (!app.getContactHelper().isAnyContactExists()) {
            ContactData contact = new ContactData();
            contact.name = "NAME";
            contact.surname = "SURNAME";
            contact.email = "newemail@gmail.com";
            contact.title = "TITLE";
            app.getContactHelper().createContact(contact);
        }
    }

}
