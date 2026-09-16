import java.util.Scanner;

public class CanteenOrderingSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] items = {
            "Siomai Rice",
            "Pancit Canton",
            "Tapsilog",
            "Lumpia",
            "Iced Tea"
        };

        double[] prices = {
            50.00,
            45.00,
            75.00,
            30.00,
            25.00
        };

        double subtotal = 0;
        int totalQuantity = 0;
        boolean isStudent = false;

        System.out.println("===== CANTEEN MENU =====");

        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-15s - $%.2f%n",
                    i + 1, items[i], prices[i]);
        }

        System.out.println();

        char orderAgain = 'Y';

        while (orderAgain == 'Y' || orderAgain == 'y') {

            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            char studentAnswer = input.next().charAt(0);

            if (itemNumber < 1 || itemNumber > 5 ||
                    quantity < 1 || quantity > 10) {

                System.out.println(
                    "Invalid order! Please enter a valid item and quantity."
                );

            } else {

                if (studentAnswer == 'Y' || studentAnswer == 'y') {
                    isStudent = true;
                }

                double amount = prices[itemNumber - 1] * quantity;

                subtotal += amount;
                totalQuantity += quantity;

                System.out.printf(
                    "Added: %s x%d = $%.2f%n",
                    items[itemNumber - 1],
                    quantity,
                    amount
                );
            }

            System.out.println();
            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = input.next().charAt(0);

            System.out.println();
        }

        double discountRate = 0;

        if (isStudent && subtotal >= 500) {
            discountRate = 0.15;
        } else if (isStudent) {
            discountRate = 0.10;
        } else if (subtotal >= 500) {
            discountRate = 0.05;
        }

        double discount = subtotal * discountRate;
        double finalAmount = subtotal - discount;

        System.out.println("===== ORDER SUMMARY =====");

        System.out.println("Total quantity: " + totalQuantity);

        System.out.printf(
            "Total amount before deductions: $%.2f%n",
            subtotal
        );

        System.out.printf(
            "Total discount: $%.2f%n",
            discount
        );

        System.out.printf(
            "Final amount to pay: $%.2f%n",
            finalAmount
        );

        input.close();
    }
}