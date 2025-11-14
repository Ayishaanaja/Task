package Encapsulation;

class Details {
 private String accountNumber;
 private String accountHolder;
 private double balance;

 public Details(String accountNumber, String accountHolder, double balance) {
	super();
	this.accountNumber = accountNumber;
	this.accountHolder = accountHolder;
	this.balance = balance;
}

 public String getAccountNumber() {
	return accountNumber;
}

 public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
 }

 public String getAccountHolder() {
	return accountHolder;
 }

 public void setAccountHolder(String accountHolder) {
	this.accountHolder = accountHolder;
 }

 public double getBalance() {
	return balance;
 }

 public void setBalance(double balance) {
	this.balance = balance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Invalid or insufficient funds.");
     }
 }
}

public class BankAccount {
 public static void main(String[] args) {
     Details account = new Details("123456789", "John Doe", 1000.0);
     System.out.println("Account Holder: " + account.getAccountHolder());
     System.out.println("Account Number: " + account.getAccountNumber());
     System.out.println("Initial Balance: " + account.getBalance());

     account.deposit(500.0);
     account.withdraw(200.0);
     account.withdraw(2000.0);
     // Final balance
     System.out.println("Final Balance: " + account.getBalance());
 }
}