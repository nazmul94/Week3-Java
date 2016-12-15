package addressBookProgramme.behaviours;
import addressBookProgramme.models.Contact;

public class ContactStreetPredicate implements ContactPredicate
{
    @Override
    public boolean test(Contact contact, String input) {
        return contact.getAddress().getStreet().equalsIgnoreCase(input);
    }
}
