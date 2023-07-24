package challenges.customer;

public class Customer {
    private String customerName;
    private double creditLimit;
    private String emailAddress;

    public String getCustomerName() {
        return customerName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Customer (String name, double creditLimit, String email) {
        customerName = name; this.creditLimit = creditLimit; emailAddress = email;
    }
    public Customer () {
        this("-", "-");
    }

    public Customer (String name, String email) {
        this(name, 0.00, email);
    }
}
