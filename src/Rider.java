class Rider extends User {
    String location;
    PaymentMethod preferredPaymentMethod;

    public Rider(String id, String name, double rating, String location, PaymentMethod paymentMethod) {
        super(id, name, rating);
        this.location = location;
        this.preferredPaymentMethod = paymentMethod;
    }

    public void requestRide(String pickup, String dropoff, RideType rideType) {
        System.out.println(name + " requested a ride from " + pickup + " to " + dropoff + " (Type: " + rideType.getType() + ")");
        // Here you can trigger the Trip class to assign a driver
    }

    public void rateDriver(Driver driver, double rating) {
        driver.updateRating(rating);
        System.out.println("Rated driver " + driver.name + ": " + rating);
    }

    public void makePayment(Trip trip) {
        trip.getPaymentMethod().processPayment(trip.getFare());
    }
}
