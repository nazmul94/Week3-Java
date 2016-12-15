package addressBookProgramme.main;
import addressBookProgramme.behaviours.*;
import addressBookProgramme.models.Contact;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static addressBookProgramme.models.GeneratedContacts.contactList;

public class TaskProcessing
{
    public static void listAllContacts()
    {
        for(Contact contact : contactList)
        {
            System.out.println(contact);
        }
    }

    public static List<Contact> searchByString(ContactPredicate contactPredicate, String input)
    {
        List<Contact> result = new ArrayList<>();
        for(Contact contact : contactList)
        {
            if(contactPredicate.test(contact, input))
            {
                result.add(contact);
            }
        }
        return result;
    }

    public static int searchByIndex(int id)
    {
        for(int i = 0; i < contactList.size(); i++)
        {
            if(contactList.get(i).getId() == id)
            {
                return i;
            }
        }
        return -1;
    }

    public static List<Contact> search(String input)
    {
        List<Contact> result;
        result = searchByString(new ContactFirstNamePredicate(), input);
        if(result.isEmpty())
        {
            result = searchByString(new ContactLastNamePredicate(), input);
        }
        if(result.isEmpty())
        {
            result = searchByString(new ContactStreetPredicate(), input);
        }
        if(result.isEmpty())
        {
            result = searchByString(new ContactCityPredicate(), input);
        }
        if(result.isEmpty())
        {
            result = searchByString(new ContactCountryPredicate(), input);
        }
        if(result.size() >= 1)
        {
            return result;
        }
        return null;
    }

    public static String createNew(List<String> data)
    {
        try
        {
            Contact temp = new Contact(
                    Integer.parseInt(data.get(0)),
                    data.get(1),
                    data.get(2),
                    Integer.parseInt(data.get(3)),
                    data.get(4),
                    data.get(5),
                    data.get(6),
                    data.get(7)
            );
            contactList.add(temp);
            return "Successfully added: " + temp.getPerson().getFirstName();
        }
        catch (Exception e)
        {
            return "Failed to add new contact: " + e;
        }
    }

    public static String editContact(int id, List<String> data)
    {
        try
        {
            if(!("".equals(data.get(0))))
            {
                contactList.get(id).setId(Integer.parseInt(data.get(0)));
            }
            if(!("".equals(data.get(1))))
            {
                contactList.get(id).getPerson().setFirstName(data.get(1));
            }
            if(!("".equals(data.get(2))))
            {
                contactList.get(id).getPerson().setLastName(data.get(2));
            }
            if(!("".equals(data.get(3))))
            {
                contactList.get(id).getAddress().setStreet(data.get(3));
            }
            if(!("".equals(data.get(4))))
            {
                contactList.get(id).getAddress().setCity(data.get(4));
            }
            if(!("".equals(data.get(5))))
            {
                contactList.get(id).getAddress().setCity(data.get(5));
            }
            if(!("".equals(data.get(6))))
            {
                contactList.get(id).getAddress().setPostCode(data.get(6));
            }
            if(!("".equals(data.get(7))))
            {
                contactList.get(id).getAddress().setCountry(data.get(7));
            }
            return "Successfully edited: " + contactList.get(id);
        }
        catch (Exception e)
        {
            return "Failure to edit: caused by " + e;
        }
    }

    public static String removeContact(int index)
    {
        String removedString;
        if(index != -1)
        {
            if (contactList.get(index) == null)
            {
                return "Removal Failed: contact ID does not exist";
            }
            else
            {
                removedString = "Successfully removed " + contactList.get(index).getPerson().getFirstName() + " " + contactList.get(index).getPerson().getLastName();
                contactList.remove(index);
            }
            return removedString;
        }
        return "Removal Failed: contact ID does not exist";
    }

    public static void sortByFirstName()
    {
        contactList.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getPerson().getFirstName().compareTo(c2.getPerson().getFirstName());
            }
        });
    }
}
