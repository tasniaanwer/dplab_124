interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCard implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPal implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}
