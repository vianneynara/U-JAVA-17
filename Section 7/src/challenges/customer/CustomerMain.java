package challenges.customer;

public class CustomerMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        printCustomerInformation(customer1);

        Customer customer2 = new Customer("Bob Kenderson", "printingneeds2@gmail.com");
        printCustomerInformation(customer2);

        Customer customer3 = new Customer("Bob Kenderson", 500.00, "printingneeds2@gmail.com");
        printCustomerInformation(customer3);
    }

    private static void printCustomerInformation(Customer customer) {
        System.out.println();
        System.out.println("Customer Name\t: " + customer.getCustomerName());
        System.out.println("Credit Limit\t: $" + customer.getCreditLimit());
        System.out.println("Email Address\t: " + customer.getEmailAddress());
        System.out.println();
    }
}
