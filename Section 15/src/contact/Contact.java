package contact;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contact {

	private String name;
	Set<String> emails = new HashSet<>();
	Set<String> phones = new HashSet<>();

	public Contact(String name) {
		this.name = name;
	}

	public Contact(String name, String email) {
		this.name = name;
		this.emails.add(email);
	}

	public Contact(String name, long phone) {
		this.name = name;
		String phoneString = String.valueOf(phone);
		this.phones.add(String.format("(%s) %s-%s",
			phoneString.substring(0, 3),
			phoneString.substring(3, 6),
			phoneString.substring(6)));
	}

	public Contact(String name, String email, long phone) {
		this.name = name;
		this.emails.add(email);
		String phoneString = String.valueOf(phone);
		this.phones.add(String.format("(%s) %s-%s",
			phoneString.substring(0, 3),
			phoneString.substring(3, 6),
			phoneString.substring(6)));
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("name: %s -> {emails: %s, phones: %s}",
			name, emails, phones);
	}

	public Contact mergeContactData(Contact contact) {

		// creates a new contact with the same name and data as this contact
		Contact newContact = new Contact(this.name);
		newContact.emails = new HashSet<>(this.emails);
		newContact.phones = new HashSet<>(this.phones);

		// adds the passed contact data to the new merged contact
		newContact.emails.addAll(contact.emails);
		newContact.phones.addAll(contact.phones);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		// casts the object to contact as it must be a contact
		Contact contact = (Contact) o;

		// checks equality not by the emails or phones but by the name
		return Objects.equals(getName(), contact.getName());
	}

	@Override
	public int hashCode() {
		return 33 * Objects.hash(getName());
	}

	public void addEmail(String companyName) {

		String[] names = name.split(" ");
		String email = String.format("%s.%s@%s.com",
			name.toLowerCase().charAt(0),
			names[names.length - 1].toLowerCase(),
			companyName.replaceAll(" ", "").toLowerCase());
		if (!emails.add(email)) {
			System.out.printf("Email '%s' already exists%n", email);
		} else {
			System.out.printf("Email '%s' added%n", email);
		}
	}

	public void replaceEmailIfExists(String oldEmail, String newEmail) {
		if (emails.contains(oldEmail)) {
			emails.remove(oldEmail);
			emails.add(newEmail);
		}
	}
}
