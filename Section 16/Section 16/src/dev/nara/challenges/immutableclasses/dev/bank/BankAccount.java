package dev.nara.challenges.immutableclasses.dev.bank;

public class BankAccount {

	public enum AccountType {
		CHECKING, SAVINGS
	}

	private final AccountType accountType;
	private final double balance;

	//package-private constructor to prevent instantiation outside of the package
	BankAccount(AccountType accountType, double balance) {
		this.accountType = accountType;
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "%s $%.2f".formatted(accountType, balance);
	}
}
