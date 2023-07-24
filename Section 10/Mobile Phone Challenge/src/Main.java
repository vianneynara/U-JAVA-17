public class Main {

    public static void main(String[] args) {

        MobilePhone phone = new MobilePhone("09952128834");

        phone.addNewContact(new Contact("Nara", "234354332"));
        phone.addNewContact(new Contact("Mathil", "723846875"));

        phone.printContacts();
    }
}
