
interface PaymentMethod {
    void processPayment(double amount);
    double calculateTotalFare(double baseFare);
}


class CreditCard implements PaymentMethod {
    private static final double FEE_PERCENTAGE = 0.02; // 2% fee for credit card

    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }

    public double calculateTotalFare(double baseFare) {
        return baseFare + (baseFare * FEE_PERCENTAGE); // Add 2% fee
    }
}
class Bkash implements PaymentMethod {
    private static final double FEE_PERCENTAGE = 0.015; // 1.5% fee for Bkash

    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Bkash.");
    }

    public double calculateTotalFare(double baseFare) {
        return baseFare + (baseFare * FEE_PERCENTAGE); // Add 1.5% fee
    }
}
class Cash implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " in Cash.");
    }

    public double calculateTotalFare(double baseFare) {
        return baseFare; // No additional fees for cash
    }
}