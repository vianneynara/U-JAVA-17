import java.util.ArrayList;
import java.util.ListIterator;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialTransaction) {
        Customer c = findCustomer(name);
        if (c == null) {
            return customers.add(new Customer(name, initialTransaction));
        }
        else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String name, double transaction) {
        Customer customer = findCustomer(name);
        if (customer != null) {
            customer.addTransaction(transaction);
            return true;
        }
        else {
            return false;
        }
    }

    private Customer findCustomer(String name) {
        ListIterator<Customer> iterator = customers.listIterator();
        while (iterator.hasNext()) {
            Customer c = iterator.next();
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
//                System.out.println("returned " + c.getName());
                return c;
            }
        }
        return null;
    }
}
