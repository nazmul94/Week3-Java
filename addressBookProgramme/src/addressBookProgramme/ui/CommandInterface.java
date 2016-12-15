package addressBookProgramme.ui;

import addressBookProgramme.main.TaskProcessing;
import addressBookProgramme.models.Contact;
import com.sun.javafx.tk.Toolkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static addressBookProgramme.models.GeneratedContacts.contactList;

public class CommandInterface
{
    private static Scanner input = new Scanner(System.in);
    private static boolean _edit = false;

    public static void display() {
        int choice;

        boolean _isRunning = true;
        while (_isRunning)
        {

            do {
                System.out.println("Welcome to employee awesome Boom programme");
                System.out.println("1. List all contacts");
                System.out.println("2. Add a new contact");
                System.out.println("3. Search contacts");
                System.out.println("4. Edit an contact");
                System.out.println("5. Remove a contact");
                System.out.println("6. Sort by first name");
                System.out.println("7. BOOM terminate");
                System.out.println("Input an option");

                choice = input.nextInt();
                System.out.println();
            } while (choice < 1 || choice > 7);

            switch (choice) {
                case 1:
                    TaskProcessing.listAllContacts();
                    break;
                case 2:
                    System.out.println(TaskProcessing.createNew(inputDetails(null)));
                    break;
                case 3:
                    System.out.println("Enter search string");
                    input.nextLine();
                    List<Contact> result = TaskProcessing.search(input.nextLine());
                    if (result != null) {
                        for (Contact contact : result)
                            System.out.println(contact);
                    } else
                        System.out.println("Not found!");
                    break;
                case 4:
                    _edit = true;
                    input.nextLine();
                    TaskProcessing.listAllContacts();
                    System.out.println("Enter ID to edit: ");
                    int index = TaskProcessing.searchByIndex(input.nextInt());
                    if(index == -1)
                    {
                        System.out.println("Record does not exist");
                    }
                    else
                    {
                        System.out.println(TaskProcessing.editContact(index, inputDetails(contactList.get(index))));
                    }
                    break;
                case 5:
                    TaskProcessing.listAllContacts();
                    System.out.println("Enter an ID to remove a contact: ");
                    int indexToRemove = TaskProcessing.searchByIndex(input.nextInt());
                    System.out.println(TaskProcessing.removeContact(indexToRemove));
                    break;
                case 6:
                    TaskProcessing.sortByFirstName();
                    TaskProcessing.listAllContacts();
                    break;
                case 7:
                    _isRunning = false;
                            break;
                    default:
                        break;
            }
        }
    }

    private static List<String> inputDetails(Contact current)
    {
        List<String> tempData = new ArrayList<>();
        input.nextLine();

        System.out.print("ID: ");
        tempData.add(input.nextLine());

        System.out.print("FirstName: ");
        tempData.add(input.nextLine());

        System.out.print("LastName: ");
        tempData.add(input.nextLine());

        System.out.print("Phone number: ");
        tempData.add(input.nextLine());

        System.out.println("Street: ");
        tempData.add(input.nextLine());

        System.out.println("City: ");
        tempData.add(input.nextLine());

        System.out.println("Postcode: ");
        tempData.add(input.nextLine());

        System.out.println("Country: ");
        tempData.add(input.nextLine());

        return tempData;
    }
}
