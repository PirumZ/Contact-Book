package controller;
import model.Contact;
import java.util.ArrayList;

public class ContactController {
    private ArrayList<Contact> contacts;

    public ContactController(ArrayList<Contact> contacts)
    {
        this.contacts = contacts;
    }

    public boolean addContact(String name, String address, String phoneNumber, String email)
    {
        Contact contact = new Contact(name, address, phoneNumber, email);
        contacts.add(contact);
        return true;
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

    public boolean deleteContact(String name)
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getName().equalsIgnoreCase(name))
            {
                contacts.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
