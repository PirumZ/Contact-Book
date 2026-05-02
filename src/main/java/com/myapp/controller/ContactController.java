package com.myapp.controller;
import com.myapp.model.Contact;

import java.io.*;
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

    public void saveContactsToFile()
    {
        String filePath = "src/main/java/com/myapp/data/data.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath)))
        {
            for (Contact contact: contacts)
            {
                writer.println(contact.toCSV());
            }
        } catch (IOException e) {
        System.err.println("Error writing to file: " + e.getMessage());
    }
    }

    public void loadContactsFromFile()
    {
        String filePath = "src/main/java/com/myapp/data/data.csv";

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4)
                {
                String name = parts[0].trim();
                String address = parts[1].trim();
                String phoneNumber = parts[2].trim();
                String email = parts[3].trim();

                contacts.add(new Contact(name, address, phoneNumber, email));
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }


    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
