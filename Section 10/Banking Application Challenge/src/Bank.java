import java.util.ArrayList;
import java.util.ListIterator;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String name) {
        if (findBranch(name) == null) {
            return branches.add(new Branch(name));
        }
        else {
            return false;
        }
    }

    public boolean addCustomer(String branchName, String name, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(name, initialTransaction);
        }
        else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String branchName, String name, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(name, transaction);
        }
        else {
            return false;
        }
    }

    private Branch findBranch(String name) {
        ListIterator<Branch> iterator = branches.listIterator();
        while (iterator.hasNext()) {
            Branch b = iterator.next();
            if (b.getName().toLowerCase().contains(name.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            int branchCount = 0;
            for (Customer c : branch.getCustomers()) {
                System.out.println("Customer: " + c.getName() + "[" + ++branchCount + "]");
                if (printTransactions) {
                    System.out.println("Transactions");
                    int transactionCount = 0;
                    for (double t : c.getTransactions()) {
                        System.out.printf("[%d]  Amount %.2f%n", ++transactionCount, t);
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
