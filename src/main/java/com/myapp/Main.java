package com.myapp;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myapp.controller.ContactController;
import com.myapp.model.Contact;
import com.myapp.view.ContactView;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ContactController controller = new ContactController();
        controller.loadContactsFromFile();
        ContactView view = new ContactView();

        view.displayGreeting();
        boolean running = true;
        while (running) {
            view.displayMenu();

            String userChoice = view.getMenuChoice();

            switch (userChoice) {
                case "1":
                    view.displayContactList(controller.getContacts());
                    break;
                case "2":
                    boolean creationStatus = controller.addContact(view.getContactInput());
                    view.creationConfirmation(creationStatus);
                    break;
                case "3":
                    String deleteName = view.getName();
                    boolean deletionStatus = controller.deleteContact(deleteName);
                    view.deletionConfirmation(deletionStatus);
                    break;
                case "4":
                    String searchName = view.getName();
                    Contact foundContact = controller.searchContact(searchName);
                    view.displayContact(foundContact);
                    break;
                case "5":
                    String nameToUpdate = view.getName();
                    boolean creationStat = controller.updateContact(nameToUpdate, view.getContactInput());
                    view.creationConfirmation(creationStat);
                case "6":
                    controller.saveContactsToFile();
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }
}

