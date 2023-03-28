package BankingApp;

import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		BankAccount ba=new BankAccount("XYZ","BA001");
		ba.showmenu();

	}

}
class BankAccount{
	int balance;
	int previoustransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname, String cid)
	{
		customerName=cname;
		customerId=cid;
	}
	
	void deposit( int amount) {
		if(amount>0) {
			balance=balance+amount;
			previoustransaction=-amount;
		}
		
	}
	void withdraw(int amount)
	{
		if(amount>0)
		{
			balance=balance-amount;
			previoustransaction=-amount;
		}
	}
	void getprevioustransaction()
	{
		if(previoustransaction > 0) {
			System.out.println("deposited:"+previoustransaction);
		}
		else if(previoustransaction<0)
		{
			System.out.println("withdrawn:"+Math.abs(previoustransaction));
		}
		else
		{
			System.out.println("no transaction occured");
		}
	}
	void showmenu()
	{
		char option='\0';
		Scanner sc1=new Scanner (System.in);
		System.out.println("Welcome"+customerName);
		System.out.println("Your Id:"+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. PreviousTransaction");
		System.out.println("E. Exit");
		
		do
		{
			System.out.println("============================");
			System.out.println("Enter an option");
			System.out.println("============================");
			option=sc1.next().charAt(0);
			System.out.println("\n");
			switch(option)
			{
			case 'A':
				System.out.println("------------------------");
				System.out.println("Balance="+balance);
				System.out.println("------------------------");
				break;
			case 'B':
			System.out.println("------------------------");
			System.out.println("Enter amount to Deposit:");
			int amount=sc1.nextInt();
			deposit(amount);
			System.out.println("\n");
			break;
			case 'C':
				System.out.println("------------------------");
				System.out.println("Enter amount to Withdraw");
				System.out.println("------------------------");
				int amount2=sc1.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
			case 'D':
				System.out.println("------------------------");
				getprevioustransaction();
				System.out.println("------------------------");
				System.out.println("\n");
				break;
			case 'E':
				System.out.println("***************");
				break;
			default:
				System.out.println("Invalid option!.Please enter again");
				break;
				
			}
			
		}while(option != 'E');
		System.out.println("Thankyou for using our service");
	}
}
