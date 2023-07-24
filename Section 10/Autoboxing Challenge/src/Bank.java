import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {
    public Customer(String name, double initialDeposit) {
        this(
                name,
                new ArrayList<>(100)
        );
        transactions.add(initialDeposit);
    }
}

public class Bank {

    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    private Customer findCustomer(String name) {

        for (Customer customer : customers) {
            if (name.equalsIgnoreCase(customer.name())) {
                return customer;
            }
        }

        return null;
    }

    public void addCustomer(String name, double initialDeposit) {

        if (findCustomer(name) == null) {
            Customer customer = new Customer(name, initialDeposit);
            customers.add(customer);
            System.out.println("New customer added: " + customer);
            return;
        }
        System.out.printf("Customer '%s' exists! %n", name);
    }

    public boolean addTransaction(Customer customer, double amount) {

        System.out.println("Transaction added to [" + customer.name() + "]: " + amount);
        return customer.transactions().add(amount);
    }

    public boolean addTransaction(String name, double amount) {
        Customer customer = findCustomer(name);
        if (customer != null) {
            System.out.println("Transaction added to [" + customer.name() + "]: " + amount);
            return customer.transactions().add(amount);
        }
        return false;
    }

    public void printStatement(Customer customer) {
        System.out.printf("[%s]'s statement, transactions: %n");
        for (double amount : customer.transactions()) {
            System.out.printf("\t%s %10.2f %n", (amount < 0) ? "[CREDIT] $" : "[DEBIT ] $", amount);
        }
    }

    public void printStatement(String name) {
        Customer customer = findCustomer(name);
        if (customer != null) {
            System.out.printf("[%s]'s statement, transactions: %n", name);
            for (double amount : customer.transactions()) {
                System.out.printf("\t%s %10.2f %n", (amount < 0) ? "[CREDIT] $" : "[DEBIT ] $", amount);
            }
            return;
        }
        System.out.printf("Customer [%s] not found!", name);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}


