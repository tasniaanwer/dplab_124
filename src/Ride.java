public class Ride {
    public RideType rideType;
    public double fare;
    public boolean isShared;

    public Ride(RideType rideType, double fare, boolean isShared) {
        this.rideType = rideType;
        this.fare = fare;
        this.isShared = isShared;
    }

    public RideType getRideType() {
        return rideType;
    }

    public double getFare() {
        return fare;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
