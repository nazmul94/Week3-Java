package addressBookProgramme.models;

import java.util.ArrayList;
import java.util.List;

public class GeneratedContacts
{
    public static List<Contact> contactList = new ArrayList<>();

    //Method to create Database
    public static void createContactList()
    {
        Contact naz = new Contact(001, "Nazmul", "Mumtahin", 7508511, "Ravens Street", "London", "E2 6BT", "England");
        Contact alex = new Contact(002, "Alex", "Kennedy", 919219, "Turin Street", "Glasgow", "NE2 2RR", "Scotland");
        Contact anna = new Contact(003, "Anna", "Michelle", 7656171, "Commercial Road", "London", "E1 2NT", "England");
        Contact adam = new Contact(004, "Adam", "Smith", 5672876, "Gants Hill", "London", "IG11 NW1", "England");
        Contact clara = new Contact(005, "Clara", "Kate", 654567, "Uxbridge Lane", "Manchester", "MW2 2OS", "England");

        contactList.add(naz);
        contactList.add(alex);
        contactList.add(anna);
        contactList.add(adam);
        contactList.add(clara);
    }
}
