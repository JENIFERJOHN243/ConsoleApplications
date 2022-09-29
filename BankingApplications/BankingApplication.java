package BankingApplications;

import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		BankingApplication bankObject = new BankingApplication();
		bankObject.startProcess();
	}
	
	private void startProcess() {
		Scanner scanner=new Scanner(System.in);
		boolean bool=false;
		BankAccount account=new BankAccount();
		System.out.println("Welcome To Bucks Bank");
		while(!bool) {
		System.out.println();
		System.out.println("1.Create Account");
		System.out.println("2.Login Account");
		System.out.println("3.Exit");
		System.out.println();
		System.out.println("Press 1 or 2 or 3 respectively");
		int choice=scanner.nextInt();
		switch (choice){
		case 1:{
			account.createAccount();
			break;
		}
		case 2:{
			account.showMenu();
			break;
		}
		case 3:{
			System.out.println("Thank You For Using Our Service");
			System.out.println();
			bool=true;
			break;
		}
		default :{
			System.out.println("Invalid Option!! Please Enter The Correct Option");
			System.out.println();
			break;
			}
		  }
	}
		}
}
