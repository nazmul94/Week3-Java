package addressBookProgramme.behaviours;
import addressBookProgramme.models.Contact;

public class ContactCityPredicate implements ContactPredicate
{
    @Override
    public boolean test(Contact contact, String input) {
        return contact.getAddress().getCity().equalsIgnoreCase(input);
    }
}
