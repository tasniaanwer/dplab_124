import java.util.UUID;
import java.util.Scanner;


class TripService {
    public Trip createTrip(String pickup, String dropoff, RideType rideType, double distance, PaymentMethod paymentMethod) {
        Trip trip = new Trip(UUID.randomUUID().toString(), pickup, dropoff, rideType, distance, paymentMethod);
        trip.fare = rideType.getRate() * distance; // Initial fare calculation
        return trip;
    }

    public void startTrip(Rider rider, String pickupLocation, String dropOffLocation, RideType rideType) {
        System.out.println("Trip started for " + rider.name + " from " + pickupLocation + " to " + dropOffLocation + ".");
    }

    public void completeTrip(Trip trip, Driver driver) {
        trip.status = "Completed";
        driver.completeTrip();
    }

    public double calculateFare(Trip trip) {
        return trip.getPaymentMethod().calculateTotalFare(trip.fare);
    }
}