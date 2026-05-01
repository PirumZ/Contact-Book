package view;
import model.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactView {

    Scanner scanner = new Scanner(System.in);
    public ContactView()
    {
    }

    public void displayGreeting()
    {
        System.out.println("""
                Hello! Welcome to NFA Corp's newest application
                It is a revolutionary contact book that integrates with new computing technology.
                Please enjoy your usage.
                """);
    }

    public void displayMenu()
    {
        System.out.println(
                """
                        1. View your contacts.
                        2. Add a new contact.
                        3. Delete a contact (WIP)
                        4. Search for a contact
                        5. Exit the program"""
        );
    }

    public String getMenuChoice()
    {
        String menuChoice = scanner.nextLine();
        return menuChoice;
    }

    public void displayContact(Contact contact)
    {
        System.out.println(contact);
    }

    public void displayContactList(ArrayList<Contact> contactList)
    {
        for(Contact contact: contactList)
        {
            System.out.println(contact);
        }
    }

    public String getName()
    {
        System.out.println("Please enter a name: ");
        String name = scanner.nextLine();
        return name;
    }

    public String getAddress()
    {
        System.out.println("Please enter an address: ");
        String address = scanner.nextLine();
        return address;
    }

    public String getPhoneNumber()
    {
        System.out.println("Please enter a phone number: ");
        String phoneNumber = scanner.nextLine();
        return phoneNumber;
    }

    public String getEmail()
    {
        System.out.println("Please enter an email: ");
        String email = scanner.nextLine();
        return email;
    }

}
