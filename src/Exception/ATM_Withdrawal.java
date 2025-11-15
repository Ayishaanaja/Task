package Exception;

import java.util.Scanner;

//Custom exception
class InsufficientFundsException extends Exception {
 public InsufficientFundsException(String message) {
     super(message);
 }
}

public class ATM_Withdrawal {
 public static void main(String[] args) {
     double balance = 5000.00;
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter withdrawal amount: ");
     double amount = sc.nextDouble();

     try {
         if (amount > balance) {
             throw new InsufficientFundsException("Insufficient balance! Cannot withdraw ₹" + amount);
         }
         balance -= amount;
         System.out.println("Withdrawal successful! Remaining balance: ₹" + balance);
     } catch (InsufficientFundsException e) {
         System.out.println("Alert: " + e.getMessage());
     } finally {
         sc.close();
         System.out.println("ATM transaction completed.");
     }
 }
}

