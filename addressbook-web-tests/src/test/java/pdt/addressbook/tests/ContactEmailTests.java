package pdt.addressbook.tests;

import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

    @Test
    public void testContactEmails() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFormEditForm = app.contact().infoFromEditorForm(contact);
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFormEditForm)));
    }


    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactEmailTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String email) {
        return email.replaceAll("\\s", "").replaceAll("-()", "");
    }
}
