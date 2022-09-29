package BankingApplications;

public class PersonalDetails {
	private String customerName;
	private long phoneNumber;
	private double balance;
	private String accountNumber;
	private String passCode;
	private double initialDepositAmount;
	private int customerId;
	private double depositAmount;
	private double withdrawAmount;
    
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setBalance(double balance) {
	 	this.balance = balance;
	 }

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}
    
    public void setInitialDepositAmount(double initialDepoistAmount) {
		this.initialDepositAmount = initialDepoistAmount;
	}
    
    public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public double getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getPassCode() {
		return passCode;
	}

	public double getInitialDepositAmount() {
		return initialDepositAmount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

}
