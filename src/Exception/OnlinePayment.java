package Exception;
import java.util.Scanner;

// Custom exception
class InvalidCardException extends Exception {
    public InvalidCardException(String message) {
        super(message);
    }
}

public class OnlinePayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your 16-digit card number: ");
        String cardNumber = sc.nextLine();

        try {
            if (cardNumber.length() < 16) {
                throw new InvalidCardException("Invalid Card Number! Must be 16 digits.");
            }
            System.out.println("Payment processed successfully!");
        } catch (InvalidCardException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Transaction attempt completed.");
        }
    }
}

