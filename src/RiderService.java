class RiderService {
    public void requestRide(Rider rider, String pickup, String dropoff, RideType rideType, TripService tripService) {
        System.out.println(rider.name + " requested a ride from " + pickup + " to " + dropoff + " (Type: " + rideType.getType() + ")");
        tripService.startTrip(rider, pickup, dropoff, rideType);
    }

    public void changePaymentMethod(Rider rider, Trip trip, PaymentMethod newPaymentMethod) {
        trip.setPaymentMethod(newPaymentMethod);
        System.out.println("Payment method changed. New fare: $" + trip.getPaymentMethod().calculateTotalFare(trip.fare));
    }

    public void makePayment(Trip trip) {
        trip.getPaymentMethod().processPayment(trip.getPaymentMethod().calculateTotalFare(trip.fare));
    }
}
