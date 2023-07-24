package challenges.bankaccount;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
//        account1.setAccountBalance(1000);
//        account1.setAccountNumber("0001");
//        account1.setCustomerEmail("printingneeds2@gmail.com");
//        account1.setCustomerName("Bob Kenderson");
//        account1.setCustomerPhone("62+ 81267679001");
//
//        printSeparator();
//        printAccountInformation(account1);
//
//        account1.withdrawFund(100);
//        System.out.println("\nAccount Balance: $" + account1.getAccountBalance());
//
//        account1.withdrawFund(1100);
//        System.out.println("\nAccount Balance: $" + account1.getAccountBalance());
//
//        account1.depositFund(500);
//        System.out.println("\nAccount Balance: $" + account1.getAccountBalance());
//
        printSeparator();
        printAccountInformation(account1);
    }

    private static void printAccountInformation(BankAccount account) {
        System.out.println("Bank Account Information");
        System.out.println("Account Number\t: " + account.getAccountNumber());
        System.out.println("Account Balance\t: $" + account.getAccountBalance());
        System.out.println("Account Holder\t: " + account.getCustomerName());
        System.out.println("Account Email\t: " + account.getCustomerEmail());
        System.out.println("Phone Number\t: " + account.setCustomerPhone());
        System.out.println();
    }

    private static void printSeparator() {
        System.out.println();
        System.out.println("-separator-");
        System.out.println();
    }
}
