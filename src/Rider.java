class Rider extends User {
    String location;

    public Rider(String id, String name, double rating, String location) {
        super(id, name, rating);
        this.location = location;
    }
}