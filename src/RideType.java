interface RideType {
    double getRate();
    String getType();
}

class Carpool implements RideType {
    public double getRate() {
        return 0.5; // Cheaper rate
    }

    public String getType() {
        return "Carpool";
    }
}
class LuxuryRide implements RideType {
    public double getRate() {
        return 2.0; // Higher rate
    }

    public String getType() {
        return "Luxury";
    }
}

class BikeRide implements RideType {
    public double getRate() {
        return 1.0; // Moderate rate
    }

    public String getType() {
        return "Bike";
    }
}
