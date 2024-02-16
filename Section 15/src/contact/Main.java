package contact;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		// retrieves from 'database'
		List<Contact> emails =  ContactData.getData("email");
		List<Contact> phones = ContactData.getData("phone");

		// prints the list
		printData("Phone List", phones);
		printData("Email List", emails);

		// sets
		Set<Contact> emailContacts = new HashSet<>(emails);
		Set<Contact> phoneContacts = new HashSet<>(phones);

		// prints the set
		printData("Phone Set", phoneContacts);
		printData("Email Set", emailContacts);

		int idx = emails.indexOf(new Contact("Robin Hood"));
		Contact robinHood = emails.get(idx);
		robinHood.addEmail("Sherwood Forest");
		robinHood.addEmail("Sherwood Forest");
		robinHood.replaceEmailIfExists("r.hood@sherwoodforest.com", "r.hood@sherwoodforest.org");
		System.out.println(robinHood);
	}

	public static void printData(String header, Collection<Contact> contacts) {

		System.out.println("----------------------------------------------");
		System.out.println(header);
		System.out.println("----------------------------------------------");
		contacts.forEach(System.out::println);
	}
}
