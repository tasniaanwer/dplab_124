class Trip {
    String id;
    String pickupLocation;
    String dropOffLocation;
    RideType rideType;
    Driver driver;
    double fare;
    double distance;
    String status;
    PaymentMethod paymentMethod;

    public Trip(String id, String pickupLocation, String dropOffLocation, RideType rideType, double distance, PaymentMethod paymentMethod) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.rideType = rideType;
        this.distance = distance;
        this.fare = calculateFare();
        this.status = "Pending";
        this.paymentMethod = paymentMethod;
    }

    public double calculateFare() {
        return distance * rideType.getRate();
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        System.out.println("Driver " + driver.name + " assigned.");
    }

    public void completeTrip() {
        this.status = "Completed";
        System.out.println("Trip completed.");
    }

    public double getFare() {
        return fare;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
