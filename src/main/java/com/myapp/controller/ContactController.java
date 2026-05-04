package com.myapp.controller;
import com.myapp.model.Contact;
import com.myapp.model.ContactInfo;

import java.io.*;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;

public class ContactController {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactController(){
    }


    public boolean addContact(ContactInfo contactInfo)
    {
        Contact contact = new Contact(
                contactInfo.getName(),
                contactInfo.getAddress(),
                contactInfo.getPhoneNumber(),
                contactInfo.getEmail()
        );
        contacts.add(contact);
        return true;
    }


    public boolean updateContact(int idToFind, ContactInfo contactInfo)
    {
        for (Contact contact : contacts)
        {
            if (contact.getId() == idToFind)
            {
                contact.setName(contactInfo.getName());
                contact.setAddress(contactInfo.getAddress());
                contact.setPhoneNumber(contactInfo.getPhoneNumber());
                contact.setEmail(contactInfo.getEmail());
                return true;
            }
        }
        return false;
    }

    public Contact searchContact(int id)
    {
        for (Contact contact : contacts)
        {
            if (contact.getId() == id)
            {
                return contact;
            }
        }
        return null;
    }

    public boolean deleteContact(int id)
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getId() == id)
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

        contacts.clear();
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            int maxId = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5)
                {

                try {
                    int id = parseInt(parts[0].trim());

                    if (id > maxId) maxId = id;
                    String name = parts[1].trim();
                    String address = parts[2].trim();
                    String phoneNumber = parts[3].trim();
                    String email = parts[4].trim();

                    contacts.add(new Contact(id, name, address, phoneNumber, email));
                } catch (NumberFormatException e)
                {
                    System.out.println("Skipping invalid line: " + line);
                }
                }
            }
            Contact.setNextId(maxId + 1);

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
