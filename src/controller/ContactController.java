package controller;
import model.Contact;
import java.util.ArrayList;

public class ContactController {
    private ArrayList<Contact> contacts;

    public ContactController(ArrayList<Contact> contacts)
    {
        this.contacts = contacts;
    }

    public void addContact(String name, String address, String phoneNumber, String email)
    {
        Contact contact = new Contact(name, address, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }


    public Contact searchContact(String name)
    {
        for (Contact contact : contacts)
        {
            if (contact.getName().equalsIgnoreCase(name))
            {
                return contact;
            }
        }
        return null;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
