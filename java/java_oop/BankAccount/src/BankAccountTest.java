public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccount bankaccount1 = new BankAccount();
		BankAccount bankaccount2 = new BankAccount();
		
		System.out.println(bankaccount1.getAccountNumber());
		System.out.println(bankaccount1.getCheckingBalance());
		System.out.println(bankaccount1.getSavingsBalance());
		System.out.println(bankaccount1.getBankAccountBalance());
		
		bankaccount1.deposit("savings", 100);
		bankaccount1.deposit("checking", 100);
		System.out.println(bankaccount1.getCheckingBalance());
		System.out.println(bankaccount1.getSavingsBalance());
		System.out.println(bankaccount1.getBankAccountBalance());
		
		bankaccount1.withdraw("savings", 50);
		bankaccount1.withdraw("checking", 50);
		bankaccount1.withdraw("checking", 25);
		System.out.println(bankaccount1.getBankAccountBalance());
		
		System.out.println(bankaccount1.getNumberOfAccountsPerUser());
		
		
		
	}

}
