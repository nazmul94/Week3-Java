package addressBookProgramme.behaviours;

import addressBookProgramme.models.Contact;

public class ContactCountryPredicate implements ContactPredicate
{
    @Override
    public boolean test(Contact contact, String input) {
        return contact.getAddress().getCountry().equalsIgnoreCase(input);
    }
}
