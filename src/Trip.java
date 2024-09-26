class Trip {
    String id;
    String pickupLocation;
    String dropOffLocation;
    RideType rideType;
    Driver driver;
    double distance;
    String status;
    PaymentMethod paymentMethod;
    double fare;

    public Trip(String id, String pickupLocation, String dropOffLocation, RideType rideType, double distance, PaymentMethod paymentMethod) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.rideType = rideType;
        this.distance = distance;
        this.paymentMethod = paymentMethod;
        this.status = "Pending";
    }
    public void assignDriver(Driver driver) {
        this.driver = driver;
        System.out.println("Driver " + driver.name + " assigned.");
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
}