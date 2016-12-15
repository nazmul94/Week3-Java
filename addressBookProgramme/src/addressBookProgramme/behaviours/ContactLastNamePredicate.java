package addressBookProgramme.behaviours;
import addressBookProgramme.models.Contact;

public class ContactLastNamePredicate implements ContactPredicate
{
    @Override
    public boolean test(Contact contact, String input) {
        return contact.getPerson().getLastName().equalsIgnoreCase(input);
    }
}
