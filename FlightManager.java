//question no 1 Flight management system
abstract class Flight {
    protected String flightNumber;
    protected String origin;
    protected String destination;
    protected double baseFare;

    public Flight(String flightNumber, String origin, String destination, double baseFare) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.baseFare = baseFare;
    }

    public abstract double calculateFare();

    public void displayDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Base Fare: " + baseFare);
    }
}
class DomesticFlight extends Flight {
    private static final double DOMESTIC_TAX_RATE = 0.10; //here domestic tax rate 10 percent 

    public DomesticFlight(String flightNumber, String origin, String destination, double baseFare) {
        super(flightNumber, origin, destination, baseFare);
    }

    @Override
    public double calculateFare() {
        //here returning the total fare by adding domestic tax.
        return baseFare + (baseFare * DOMESTIC_TAX_RATE);
    }

    @Override
    public void displayDetails() { //this function will display the details of flight
        super.displayDetails();
        System.out.println("Flight Type: Domestic");
        System.out.println("Total Fare (with 10% domestic tax): " + calculateFare());
    }
}
class InternationalFlight extends Flight {
    private static final double INTERNATIONAL_TAX_RATE = 0.20;
    private double immigrationFee;

    public InternationalFlight(String flightNumber, String origin, String destination, double baseFare, double immigrationFee) {
        super(flightNumber, origin, destination, baseFare);
        this.immigrationFee = immigrationFee;
    }

    @Override
    public double calculateFare() {
        return baseFare + (baseFare * INTERNATIONAL_TAX_RATE) + immigrationFee;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Flight Type: International");
        System.out.println("Immigration Fee: " + immigrationFee);
        System.out.println("Total Fare (with 20% international tax + immigration fee): " + calculateFare());
    }
}
public class FlightManager {
    public static void main(String[] args) {
        Flight[] flights = new Flight[3];

        flights[0] = new DomesticFlight("D123", "Delhi", "Mumbai", 5000);
        flights[1] = new InternationalFlight("I456", "Delhi", "London", 30000, 5000);
        flights[2] = new DomesticFlight("D789", "Chennai", "Bangalore", 4000);

        for (Flight flight : flights) {
            System.out.println("-----------Hello Captain Gulafshan here Good Morning-------");
            flight.displayDetails();
        }
    }
    //here find the main method to call flight managememt system.
}
