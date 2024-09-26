class Driver extends User {
    String vehicleType;
    String location;
    boolean isAvailable;

    public Driver(String id, String name, double rating, String vehicleType, String location) {
        super(id, name, rating);
        this.vehicleType = vehicleType;
        this.location = location;
        this.isAvailable = true;
    }
    public void acceptRide() {
        if (isAvailable) {
            System.out.println(name + " accepted the ride.");
            isAvailable = false;
        } else {
            System.out.println("Driver is not available.");
        }
    }
    public void startTrip() {
        System.out.println("Trip started by " + name);
    }

    public void completeTrip() {
        System.out.println("Trip completed by " + name);
        this.isAvailable = true;
    }

    public void updateRating(double newRating) {
        this.rating = (this.rating + newRating) / 2;
    }
}