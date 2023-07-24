import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        for (Contact c : myContacts) {
            if (c.getName().equalsIgnoreCase(contact.getName())) {
                return false;
            }
        }
        return myContacts.add(contact);
    }

    public boolean updateContact(Contact contact, Contact newContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(contact.getName())) {
                myContacts.add(i, newContact);
                return true;
            }
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(contact.getName())) {
                myContacts.remove(i);
                return true;
            }
        }
        return false;
    }

    private int findContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(contact.getName())) {
                return i;
            }
        }
        return -1;
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        for (Contact c : myContacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact c = myContacts.get(i);
            System.out.printf("%d. %s -> %s%n", (i + 1), c.getName(), c.getPhoneNumber());
        }
    }
}
