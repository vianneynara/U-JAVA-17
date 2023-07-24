public class BankTest {

    public static void main(String[] args) {
        Bank tailBank = new Bank("tailBank");

        tailBank.addCustomer("Nara", 100);
        tailBank.addCustomer("Mathil", 100);

        tailBank.addTransaction("nara", 165);
        tailBank.addTransaction("nara", 233);
        tailBank.addTransaction("nara", 25);
        tailBank.addTransaction("nara", -15);
        tailBank.addTransaction("nara", -120);

        tailBank.addTransaction("Mathil", 121);
        tailBank.addTransaction("Mathil", -50);
        tailBank.addTransaction("Mathil", 75);

        tailBank.printStatement("Nara");
        tailBank.printStatement("Bob");
    }
}
