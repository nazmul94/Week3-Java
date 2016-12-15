package addressBookProgramme.behaviours;
import addressBookProgramme.models.Contact;

public interface ContactPredicate
{
    boolean test(Contact contact, String input);
}
