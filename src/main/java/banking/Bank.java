package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts = null;
	
	public Bank() {
		// complete the function
		if(accounts == null) {
			accounts = new LinkedHashMap<>();
	    }
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long count = new Long(accounts.size()+1);
		 CommercialAccount commercialAccount = new CommercialAccount(company, count, pin, startingDeposit);
		// complete the function
		accounts.put(count, commercialAccount); 
        return commercialAccount.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long count = new Long(accounts.size()+1);
		ConsumerAccount consumerAccount = new ConsumerAccount(person, count, pin, startingDeposit);
		// complete the function
		accounts.put(count, consumerAccount); 
        return consumerAccount.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
        return getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
        return getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
        return getAccount(accountNumber).debitAccount(amount);
	}
}
