package methodSynchronization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class BankAccount implements Serializable {
    private String accountNumber;
    private double balance;
    private String transactionDetails;
    public BankAccount(String accountNumber, double balance, String transactionDetails) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionDetails = transactionDetails;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getTransactionDetails() {
        return transactionDetails;
    }

    @Override
    public String toString() {
        return "BankAccount [Account Number=" + accountNumber + ", Balance=" + balance + ", Transaction: " + transactionDetails + "]";
    }
}

class TransactionSerializer {
    public synchronized void saveTransaction(BankAccount account) {
        try (FileOutputStream fileOut = new FileOutputStream("bank_transactions.ser", true); // Append mode
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(account);
            System.out.println("Transaction for account " + account.getAccountNumber() + " saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class BankTransactionThread extends Thread {
    private BankAccount account;

    public BankTransactionThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
    	TransactionSerializer ts=new TransactionSerializer();
        ts.saveTransaction(account);
    }
}

public class BankTransactionApp {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("ACC123", 1000.0, "Deposit of $500");
        BankAccount account2 = new BankAccount("ACC456", 1500.0, "Withdrawal of $200");
        BankAccount account3 = new BankAccount("ACC789", 2000.0, "Deposit of $300");

        Thread thread1 = new BankTransactionThread(account1);
        Thread thread2 = new BankTransactionThread(account2);
        Thread thread3 = new BankTransactionThread(account3);

        thread1.start();
        thread2.start();
        thread3.start();

//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println("All bank transactions have been processed.");
    }
}
