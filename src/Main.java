import controller.ContactController;
import model.Contact;
import view.ContactView;

 void main() {
        ArrayList<Contact> contactList = new ArrayList<>();
        ContactController controller = new ContactController(contactList);

        controller.loadContactsFromFile();

        ContactView view = new ContactView();

        view.displayGreeting();
        boolean running = true;
        while (running) {
            view.displayMenu();

            String userChoice = view.getMenuChoice();

            switch (userChoice) {
                case "1":
                    ArrayList<Contact> contacts = controller.getContacts();
                    view.displayContactList(contacts);
                    break;
                case "2":
                    String name = view.getName();
                    String address = view.getAddress();
                    String phoneNumber = view.getPhoneNumber();
                    String email = view.getEmail();
                    boolean creationStatus = controller.addContact(name, address, phoneNumber, email);
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
                    controller.saveContactsToFile();
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
}

