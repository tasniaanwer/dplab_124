
import java.util.UUID;
import java.util.Scanner;

public class RideSharingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating payment methods
        PaymentMethod creditCard = new CreditCard();
        PaymentMethod bkash = new Bkash();
        PaymentMethod cash = new Cash();

        // Creating ride types
        RideType carpool = new Carpool();
        RideType luxury = new LuxuryRide();
        RideType bike = new BikeRide();

        // Creating a rider
        Rider rider = new Rider("1", "Tasnia", 4.5, "Downtown");

        // RiderService and TripService instances
        RiderService riderService = new RiderService();
        TripService tripService = new TripService();

        // Login as rider
        System.out.println("Logged in as Rider: " + rider.name);

        // Select payment method
        System.out.println("Select Payment Method: 1. Credit Card  2. Bkash  3. Cash");
        int paymentChoice = scanner.nextInt();
        PaymentMethod selectedPaymentMethod = switch (paymentChoice) {
            case 1 -> creditCard;
            case 2 -> bkash;
            case 3 -> cash;
            default -> cash;
        };

        // Enter pickup and drop-off locations
        System.out.println("Enter Pickup Location:");
        scanner.nextLine();  // Consume newline
        String pickupLocation = scanner.nextLine();

        System.out.println("Enter Drop-off Location:");
        String dropOffLocation = scanner.nextLine();

        // Choose ride type
        System.out.println("Choose Ride Type: 1. Carpool  2. Luxury  3. Bike");
        int rideTypeChoice = scanner.nextInt();
        RideType rideType = switch (rideTypeChoice) {
            case 1 -> carpool;
            case 2 -> luxury;
            case 3 -> bike;
            default -> carpool;
        };

        // Create a trip
        Trip trip = tripService.createTrip(pickupLocation, dropOffLocation, rideType, 10.0, selectedPaymentMethod);
        riderService.requestRide(rider, pickupLocation, dropOffLocation, rideType, tripService);

        // Assign driver and start the trip
        Driver driver = new Driver("101", "John", 4.8, "Luxury Car", "Uptown");
        trip.assignDriver(driver);
        driver.acceptRide();

        // Display current fare
        double fare = tripService.calculateFare(trip);
        System.out.println("Estimated Fare with current payment method: $" + fare);

        // Option to change payment method
        System.out.println("Do you want to change the payment method? 1. Yes  2. No");
        int changePaymentMethodChoice = scanner.nextInt();
        if (changePaymentMethodChoice == 1) {
            System.out.println("Select New Payment Method: 1. Credit Card  2. Bkash  3. Cash");
            paymentChoice = scanner.nextInt();
            PaymentMethod newPaymentMethod = switch (paymentChoice) {
                case 1 -> creditCard;
                case 2 -> bkash;
                case 3 -> cash;
                default -> cash;
            };
            riderService.changePaymentMethod(rider, trip, newPaymentMethod);
        }

        // Complete the trip and make payment
        driver.startTrip();
        tripService.completeTrip(trip, driver);
        riderService.makePayment(trip);
    }
}