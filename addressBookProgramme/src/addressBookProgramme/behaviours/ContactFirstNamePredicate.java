package addressBookProgramme.behaviours;
import addressBookProgramme.models.Contact;

import java.util.List;

public class ContactFirstNamePredicate implements ContactPredicate {
    @Override
    public boolean test(Contact contact, String input) {
        return contact.getPerson().getFirstName().equalsIgnoreCase(input);
    }
}
