public class RideSharingApp {
    public static void main(String[] args) {
        // Creating payment methods
        PaymentMethod creditCard = new CreditCard();
        PaymentMethod paypal = new PayPal();

        // Creating ride types
        RideType carpool = new Carpool();
        RideType luxury = new LuxuryRide();
        RideType bike = new BikeRide();

        // Creating rider and driver
        Rider rider = new Rider("1", "Tasnia", 4.5, "Downtown", creditCard);
        Driver driver = new Driver("101", "John", 4.8, "Luxury Car", "Uptown");
        // Creating a trip
        Trip trip = new Trip("T001", "Downtown", "Airport", luxury, 10.0, creditCard);

        // Assigning driver and starting trip
        trip.assignDriver(driver);
        driver.acceptRide(trip);
        driver.startTrip();
        driver.completeTrip();

        // Completing trip and making payment
        trip.completeTrip();
        rider.makePayment(trip);

        // Rating driver
        rider.rateDriver(driver, 5.0);
    }
}
