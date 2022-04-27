import java.util.*;

class Taxi {
	char driver;
	String carModel;
	double rating;
	int distancefromCustomer;
	String [] destination;
	
	Taxi(char driver, String carModel, double rating, int distancefromCustomer,String destination) {
		this.driver = driver;
		this.carModel = carModel;
		this.rating = rating;
		this.distancefromCustomer = distancefromCustomer;
		this.destination = destination.split(",");
	}
	
	public void printDetails() {
		System.out.print(this.driver + " " + this.carModel + " " + this.rating + " " + this.distancefromCustomer);
		for(int i=0;i<this.destination.length;i++)
			System.out.print(" " + this.destination[i]);
		System.out.println(" ");
	}
	
	
	public boolean isTaxiAvailableToDestination(String destination) {
		for(int i=0;i<this.destination.length;i++) {
			if(this.destination[i].equals(destination))
				return true;
		}
		return false;
	}
	
	public boolean isCarModelAvailable(String model) {
		if(this.carModel.equals(model))
			return true;
		return false;
	}
	
	public int getDistanceFromCustomer() {
		return this.distancefromCustomer;
	}
	
	public double getRating() {
		return this.rating;
	}
	
	public char getDriverDetails() {
		return this.driver;
	}
}

class TaxiDetails {
	ArrayList <Taxi> taxiDetails = new ArrayList <Taxi> ();
	
	public void addTaxi(Taxi taxi) {
		this.taxiDetails.add(taxi);
	}
	
	public void printTaxiDetails() {
		for(Taxi taxi : taxiDetails) {
			taxi.printDetails();
		}
	}
	
	public char checkCarAvailability(double distance, String model, String destination) {
		Taxi taxiNearToCustomer = null;
		int minimumDistance = Integer.MAX_VALUE;
		char driver = 'z';
		for(Taxi taxi : taxiDetails) {
			if(taxi.isCarModelAvailable(model)) {
				if(taxi.getDistanceFromCustomer() < minimumDistance && taxi.getRating() >= 4 && taxi.isTaxiAvailableToDestination(destination)) {
					taxiNearToCustomer = taxi;
					minimumDistance = taxi.getDistanceFromCustomer();
					driver = taxi.getDriverDetails();
				}
				
			}
				
		}
		if(driver != 'z')
			return driver;
		else
			throw new Error("The requested model not available");
	}
}

public class TaxiBooking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int stop = 2;
		char driver;
		TaxiBooking taxiBooking = new TaxiBooking();
		Taxi a = new Taxi('a',"5seater",4,500,"gurgaon,noida,delhi");
		Taxi b = new Taxi('b',"hatchback",4.3,1000,"gurgaon");
		Taxi c = new Taxi('c',"5seater",4.8,200,"noida");
		Taxi d = new Taxi('d',"sedan",4.1,700,"noida");
		Taxi e = new Taxi('e',"5seater",4.7,430,"delhi");
		TaxiDetails taxiDetails = new TaxiDetails();
		taxiDetails.addTaxi(a);
		taxiDetails.addTaxi(b);
		taxiDetails.addTaxi(c);
		taxiDetails.addTaxi(d);
		taxiDetails.addTaxi(e);
		System.out.println("Press 1- Start 2- Stop");
		int customerChoice = sc.nextInt();
		while(customerChoice != stop) {
			System.out.println("Enter the distance you want to travel (in Kms)");
			double distance = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the car model you want to travel");
			String model = sc.next();
			System.out.println("Enter the destination you want to travel");
			String destination = sc.next();
			System.out.println("List of Drivers with Details:");
			taxiDetails.printTaxiDetails();
			try {
				driver = taxiDetails.checkCarAvailability(distance, model,destination);
				System.out.println("Driver " + driver + " will get you to the destination");
				taxiBooking.printBill(distance);
				
			}
			catch (Error err) {
				System.out.println("The requested car is not available");
				continue;
			}
			
			System.out.println("Press 1-Continue 2- Stop");
			customerChoice = sc.nextInt();
			}
		

	}
	
	public void printBill(double distance) {
		System.out.println("Your charge will be Rs." + (distance*8) );
	}

}
