package BankingApplications;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankAccount {
	Scanner scanner = new Scanner(System.in);
	Random random=new Random();
	ArrayList<PersonalDetails> accountList= new ArrayList<>();
	int unqiueID=1;
   
	void createAccount() {
		PersonalDetails details=new PersonalDetails();
		boolean boolValue=false;
		System.out.println("Enter Your Name");
		String customerName = scanner.next();
		details.setCustomerName(customerName);
		System.out.println();
		
		System.out.println("Enter Your PhoneNumber");
		long phoneNumber = scanner.nextLong();
		details.setPhoneNumber(phoneNumber);
		System.out.println();
		
		while(!boolValue) {
			System.out.println("Enter The Amount to be Deposit :");
			System.out.println("MINIMUM AMOUNT SHOULD BE 500");
			double initialDepositAmount =scanner.nextDouble();
			if(checkInitailDepoistAmount(initialDepositAmount)) {
				details.setInitialDepositAmount(initialDepositAmount);
				details.setBalance(initialDepositAmount);
				details.setDepositAmount(initialDepositAmount);
				boolValue=true;
			}else {
				System.out.println("Enter a Valid Amount !!");
			}
			System.out.println();
		}
		
		String accountNumber="BB";
		String passCode="";
		for(int index=0;index<14;index++) {
			int num=random.nextInt(9);
			accountNumber+=Integer.toString(num);
		}
		details.setAccountNumber(accountNumber);
		
		for(int index=0;index<4;index++) {
			passCode+=random.nextInt(5);
		}
		details.setPassCode(passCode);
		
		details.setCustomerId(unqiueID);
		unqiueID++;
		accountList.add(details);
		System.out.println("Successfully Your Account is Created");
		System.out.println();
		System.out.println("Your Account Name : "+details.getCustomerName());
		System.out.println("Your Account Number : "+details.getAccountNumber());
		System.out.println("Your Customer ID :"+details.getCustomerId());
		System.out.println("Your PassCode (KINDLY DON'T SHARE YOUR PASSCODE WITH ANYONE) : "+details.getPassCode());
		System.out.println("Your Current Balance :"+details.getBalance());
		System.out.println();
	}

	void showMenu() {
		int option;
		boolean boolValue=false;
		while(!boolValue) {

		System.out.println("Enter Your Account Name : ");
		String userName = scanner.next();
		
		System.out.println("Enter Your PassCode :");
		String passWord = scanner.next();
		
		System.out.println("Enter Your Customer ID :");
		int userID=scanner.nextInt();
		if(checkAccount(userName,passWord,userID)) {
		while(!boolValue) {

		System.out.println();
		System.out.println("1 : Check Your Balance");
		System.out.println("2 : Deposit");
		System.out.println("3 : Withdraw");
		System.out.println("4 : Mini Statement");
		System.out.println("5 : Exit The System");
		System.out.println("----------------------");
		System.out.println();
			System.out.println("Enter Your Option");
			option=scanner.nextInt();
			
			switch (option){
			case 1:{
				checkBalance(userID);
				System.out.println();
				break;

			}
			case 2:{
				deposit(userID);
				System.out.println();
				break;
			}
			case 3:{
				withdraw(userID);
				System.out.println();
				break;
			}
			case 4:{
				getMiniStatement(userID);
				System.out.println();
				break;
			}
			case 5:{
				boolValue=true;
				break;
			}
		
			default:{
				System.out.println("Invalid Option!!Please Enter Correct Option");
				System.out.println();
				}
			}
		}
		 }
		 else {
			System.out.println("Invalid Name/PassWord");
			System.out.println("1.Try Agian \n2.Back to Home Page");
			int input = scanner.nextInt();
			if(input == 1) {
				continue;
			}
			else if(input == 2) {
				break;
			}else {
				System.out.println("Invalid Input");
				break;
			}
			}
		}
	}

	private boolean checkAccount(String userName, String passWord, int userID) {
		for(int index=0;index<accountList.size();index++) {
			if((accountList.get(index).getCustomerName()).equals(userName)&&
					(accountList.get(index).getCustomerId())==userID) {
					return true;
			}
		}
		return false;
	}

	private void getMiniStatement(int userID) {
		for(int index=0;index<accountList.size();index++) {
			if(accountList.get(index).getCustomerId()==userID) {
			System.out.println();
			System.out.println("Last WithDrawal Amount :"+accountList.get(index).getWithdrawAmount());
			System.out.println("Last Deposit Amount :"+accountList.get(index).getDepositAmount());
			System.out.println("Your Net Balance :"+accountList.get(index).getBalance());
			System.out.println();
		}
			}
	}

	private void withdraw(int userID) {
		System.out.println("Enter An Amount To Withdraw ");
		double amount2 = scanner.nextInt();
		for(int index=0;index<accountList.size();index++) {
			if(accountList.get(index).getCustomerId()==userID) {
				if(accountList.get(index).getBalance()>amount2) {
					accountList.get(index).setWithdrawAmount(amount2);
					accountList.get(index).setBalance(accountList.get(index).getBalance() - amount2);
					System.out.println("Withdrawl Amount: "+amount2);
					System.out.println("Your Net Balance after Withdraw: "+accountList.get(index).getBalance());
					System.out.println();
				}else {
					System.out.println("Insufficient Balance");
					System.out.println();
				}
			}
		}
	}

	private void deposit(int userID) {
		System.out.println("Enter an amount to deposit ");
		double amount = scanner.nextInt();
		for(int index=0;index<accountList.size();index++) {
			if(accountList.get(index).getCustomerId()==userID) {
			if(amount > 0) {
				accountList.get(index).setDepositAmount(amount);
				accountList.get(index).setBalance(accountList.get(index).getBalance()+ amount);
				System.out.println("Deposited Amount: "+amount);
				System.out.println("Your Net Balance after deposit: "+accountList.get(index).getBalance());
				System.out.println();
			}else {
				System.out.println("Enter a Valid Amount");
				System.out.println();
			}
		}
			}
	}
	private void checkBalance(int userID) {
		for(int index=0;index<accountList.size();index++) {
			if(accountList.get(index).getCustomerId()==userID) {
			System.out.println();
			System.out.println("Welcome "+accountList.get(index).getCustomerName());
			System.out.println("Your Account Number : "+accountList.get(index).getAccountNumber());
			System.out.println("Your Net Balance = "+accountList.get(index).getBalance());
			}
		}
	}
	
	private boolean checkInitailDepoistAmount(double initialDepositAmount) {
		if(initialDepositAmount >=500) {
			return true;
		}
		return false;
	}
	
	

}
