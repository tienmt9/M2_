import java.util.Scanner;

public class ContactManagement {
    protected static Scanner scanner = new Scanner(System.in);
    protected static Contact[] contacts ;
    protected static int contactsCount = 0;

    protected static void createContact(int contactNumber) {
        contacts = new Contact[contactNumber];
    }

    protected static void addNewContacts(String id, String name, String phone, String email, String address) {
        if (contactsCount >= contacts.length) {
            increaseArraySize();
        }
        contacts[contactsCount] = new Contact(id, name, phone, email, address);
        contactsCount++;
        System.out.println("Contact added successfully!");
    }

    protected static void increaseArraySize() {
        int newSize = contacts.length + 1;
        Contact[] newContacts = new Contact[newSize];
        for (int i = 0; i < contacts.length; i++) {
            newContacts[i] = contacts[i];
        }
        contacts = newContacts;
        System.out.println("Array size increased to " + newSize);
    }

    protected static void removeExistingContact(String phone) {
        int indexToRemove = -1;

        for (int i = 0; i < contactsCount; i++) {
            if (contacts[i].phone.equals(phone)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < contactsCount - 1; i++) {
                contacts[i] = contacts[i + 1];
            }
            contacts[contactsCount - 1] = null;
            contactsCount--;
            System.out.println("Contact with input Phone " + phone + " has been removed.");
        } else {
            System.out.println("Contact with input Phone " + phone + " not found.");
        }
    }

    protected static void editExistingContact(String phone) {
        int indexToUpdate = -1;

        for (int i = 0; i < contactsCount; i++) {
            if (contacts[i].phone.equals(phone)) {
                indexToUpdate = i;
                break;
            }
        }

        if (indexToUpdate != -1) {
            System.out.print("Enter new Contact ID: ");
            String newID = scanner.nextLine();
            System.out.print("Enter new Contact Name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new Contact Phone: ");
            String newPhone = scanner.nextLine();
            System.out.print("Enter new Contact Email: ");
            String newEmail = scanner.nextLine();
            System.out.print("Enter new Contact Address: ");
            String newAddress = scanner.nextLine();
            scanner.nextLine();

            contacts[indexToUpdate].id = newID;
            contacts[indexToUpdate].name = newName;
            contacts[indexToUpdate].phone = newPhone;
            contacts[indexToUpdate].email = newEmail;
            contacts[indexToUpdate].address = newAddress;

            System.out.println("Contact with input Phone " + phone + " has been updated.");
        } else {
            System.out.println("Contact with input Phone " + phone + " not found.");
        }
    }

    protected static void showOurContacts() {
        if (contactsCount == 0) {
            System.out.println("No contact to display.");
        } else {
            for (int i = 0; i < contactsCount; i++) {
                System.out.println(contacts[i]);
            }
        }
    }

    protected static void searchExistingContact(String phone) {
        int indexToSearch = -1;

        for (int i = 0; i < contactsCount; i++) {
            if (contacts[i].phone.equals(phone)) {
                indexToSearch = i;
                break;
            }
        }

        if (indexToSearch != -1) {
            System.out.println(contacts[indexToSearch]);
        } else {
            System.out.println("Contact with input Phone " + phone + " not found.");
        }
    }
}

// array list




