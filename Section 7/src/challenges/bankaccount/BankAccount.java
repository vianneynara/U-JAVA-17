package challenges.bankaccount;

public class BankAccount {

    private String accountNumber;
    private double accountBalance = 100.00;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public BankAccount () {
        this("00000", 0.00, "-", "-", "-"); // must be executed before the other lines
        System.out.println("Empty Bank Account Created");
    }
    public BankAccount (String number, double balance, String customerName, String email, String phoneNumber) {
        accountNumber = number;
        setAccountNumber(number); // the same, but not recommended
        accountBalance = balance;
        this.customerName = customerName;
        customerEmail = email;
        customerPhone = phoneNumber;
        System.out.println("Bank Account Created");
    }

    public BankAccount(String customerName, String customerEmail, String customerPhone) {
        this("00000", 0.00, customerName, customerEmail, customerPhone);
//        this.customerName = customerName;
//        this.customerEmail = customerEmail;
//        this.customerPhone = customerPhone;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String setCustomerPhone() {
        return customerPhone;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        System.out.println("Set account number to " + accountNumber);
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
        System.out.printf("Set balance to $%s.00\n", accountBalance);
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
        System.out.println("Set customer name to " + customerName);
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        System.out.println("Set email to " + customerEmail);
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
        System.out.println("Set phone number to " + customerPhone);
    }

    public void depositFund(int amount) {
        this.accountBalance += amount;
            System.out.printf("Successfully deposited $%s to the account\n", amount);
            System.out.printf("Your current balance is $%s\n", this.getAccountBalance());
    }

    public void withdrawFund(int amount) {
        if ((this.accountBalance - amount) < 0) {
            System.out.printf("Insufficient balance to withdraw (balance: $%s)\n", this.accountBalance);
        } else {
            this.accountBalance -= amount;
            System.out.printf("Successfully withdrawn $%s from account\n", amount);
            System.out.printf("Your current balance is $%s\n", this.getAccountBalance());
        }
    }
}
