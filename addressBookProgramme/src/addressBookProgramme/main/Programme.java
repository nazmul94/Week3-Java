package addressBookProgramme.main;

import addressBookProgramme.models.GeneratedContacts;
import addressBookProgramme.ui.CommandInterface;
import addressBookProgramme.ui.SwingUI;

public class Programme
{
    public static void main(String[] args)
    {
        GeneratedContacts.createContactList();

        TaskProcessing.listAllContacts();

        new SwingUI();

        //CommandInterface.display();
    }
}
