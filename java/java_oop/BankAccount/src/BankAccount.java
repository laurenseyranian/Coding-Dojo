import java.util.Random;

public class BankAccount {
	
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	public static int numberOfAccountsPerUser = 0;
	public static double bankAccountBalance = 0.0;
	
	public BankAccount () {
		this.accountNumber = generateAccountNumber();
		
		numberOfAccountsPerUser ++;
	}
	
	private String generateAccountNumber() {
		String accountNumber = "";
		Random r = new Random();
		for(int i = 0 ; i < 10 ; i ++) {
			accountNumber += String.valueOf(r.nextInt(9));
		}
		return accountNumber;	
	}
	
	public double deposit(String accountType,double amount) {
		if (accountType.equals("savings")) {
			this.savingsBalance += amount;
			bankAccountBalance += amount;
			return this.savingsBalance;
		} else {
			this.checkingBalance += amount;
			bankAccountBalance += amount;
			return this.checkingBalance;
		}
	}
	public double withdraw(String accountType,double amount) {
		if (accountType.equals("savings")) {
			this.savingsBalance -= amount;
			bankAccountBalance -= amount;
			return this.savingsBalance;
		} else {
			this.checkingBalance -= amount;
			bankAccountBalance -= amount;
			return this.checkingBalance;
		}
	}
//	GETTERS
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public static int getNumberOfAccountsPerUser() {
		return numberOfAccountsPerUser;
	}
	public static double getBankAccountBalance() {
		return bankAccountBalance;
	}
}



