import java.util.*;

class Taxi {
	int taxiNo;
	char location = 'a';
	int earning = 0;
	int pickupTime = 0;
	
	Taxi(int taxiNo) {
		this.taxiNo = taxiNo;
	}
	
	public void printTaxiDetails() {
		System.out.println(taxiNo + " " + location + " " + earning + " "+ pickupTime);
	}
	
	public int isTaxiFree(int pickuptime, char pickupPoint) {
		if(location == pickupPoint && pickuptime >= pickupTime) {
			return 1;
		}
		return 0;
	}
	
	public int isTaxiFree(int pickuptime) {
		if(pickuptime >= pickupTime)
			return 1;
		return 0;
	}
	
	
	public int getTaxiNumber () {
		System.out.println("Taxi no:" + this.taxiNo);
		return this.taxiNo;
	}
	
	public void updatePickupTime(int droptime) {
		
		this.pickupTime = droptime;
		System.out.println("Pickup time:" + this.pickupTime);
	}
	
	public void updateEarning(int amount) {
		
		this.earning += amount;
		System.out.println("Taxi earning : "+ this.earning);
	}
	
	public void updateLocation(char droppoint) {
		
		this.location = droppoint;
		System.out.println("Current location : " + this.location);
	}
	
	public int calculateDistance(char pickuppoint) {
		return Math.abs(pickuppoint - this.location);
	}
	
	public Taxi compareEarning(Taxi taxi) {
		if(this.earning > taxi.earning)
			return taxi;
		return null;
	}
	
}
 class TaxiDetails {
	 ArrayList <Taxi> taxi = new ArrayList <Taxi> ();
	 
	 public void addTaxi(Taxi a) {
		 taxi.add(a);
	 }
	 
	 public void getTaxiDetails() {
		 Iterator <Taxi> it = taxi.iterator();
		 while(it.hasNext()) {
			 Taxi taxiDetails = it.next();
			 taxiDetails.printTaxiDetails();
		 }
	 }
	 
	 public Taxi checkAvailability(int pickupTime, char pickupPoint, char dropPoint) {
		 Iterator <Taxi> it = taxi.iterator();
		 while(it.hasNext()) {
			 Taxi taxidetails = it.next();
			 int availability = taxidetails.isTaxiFree(pickupTime, pickupPoint);
			 if(availability == 1)
				 return taxidetails;
		 }
		 int shortestDistance = 6;
		 Taxi nearlyAvailableTaxi = null;
		 Taxi lowearningtaxi = null;
		 int available = 0;
		 Iterator <Taxi> iter = taxi.iterator();
		 while(iter.hasNext()) {
			 Taxi availableTaxi = iter.next();
			 int distance = availableTaxi.calculateDistance(pickupPoint);
			 available = availableTaxi.isTaxiFree(pickupTime);
			 if(distance < shortestDistance && available == 1) {
				 shortestDistance = distance;
				 nearlyAvailableTaxi = availableTaxi;
				 lowearningtaxi = nearlyAvailableTaxi;
			 }
			 else if(distance == shortestDistance && available == 1) {
				 lowearningtaxi = availableTaxi.compareEarning(nearlyAvailableTaxi);
				 if(lowearningtaxi == null)
					 lowearningtaxi = availableTaxi;
			 }
		 }
		 if(available == 0)
			 return null;
		 
		 return lowearningtaxi;
				 
	 }
 }
 

class Booking {
	int bookingId;
	int customerId;
	char pickupPoint;
	char dropPoint;
	int taxiNo;
	int pickupTime;
	int dropTime;
	int earning;
	
	Booking(int bookingId, int customerId, char pickupPoint, char dropPoint, int taxiNo, int pickupTime) {
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.taxiNo = taxiNo;
		this.pickupTime = pickupTime;
	}
	
	
	public int calculateDropTime(int pickuptime, char pickupPoint, char dropPoint) {
		this.dropTime = pickuptime + (dropPoint - pickupPoint);
		System.out.println("Drop time:" + this.dropTime);
		return this.dropTime;		
		
	}
	
	public int calculateEarning(char pickuppoint, char droppoint) {
		this.earning = 100 + ((15*(droppoint - pickuppoint))-5)*10;
		System.out.println("Earning:" + this.earning);
		return this.earning;
		
	}
	
	public void printBookingDetails () {
		System.out.println(bookingId + " " + customerId + " "+ taxiNo + " " + pickupPoint + " " + dropPoint + " "+ pickupTime + " " + dropTime + " "+ earning);
	}
	
	
}
public class CallTaxiBooking {

	public static void main(String[] args) {
		int bookingid = -1;
		Scanner sc = new Scanner(System.in);
		TaxiDetails taxidetails = new TaxiDetails();
		Taxi a = new Taxi(0);
		taxidetails.addTaxi(a);
		Taxi b = new Taxi(1);
		taxidetails.addTaxi(b);
		Taxi c = new Taxi(2);
		taxidetails.addTaxi(c);
		Taxi d = new Taxi(3);
		taxidetails.addTaxi(d);
		Taxi e = new Taxi(4);
		taxidetails.addTaxi(e);
		Taxi f = new Taxi(5);
		taxidetails.addTaxi(f);
		taxidetails.getTaxiDetails();
		int choice =1;
		while(choice != 0) {
			System.out.println("Enter the Customer Id");
			int customerId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Pickup point");
			char pickupPoint = sc.nextLine().charAt(0);
			System.out.println("Enter the Drop point");
			char dropPoint = sc.nextLine().charAt(0);
			System.out.println("Enter the pickup time");
			int pickupTime = sc.nextInt();
			Taxi taxiAvailable = taxidetails.checkAvailability(pickupTime,pickupPoint, dropPoint);
			taxiAvailable.printTaxiDetails();
			if(taxiAvailable != null) {
				//int droptime = taxiAvailable.calculateDropTime(pickupTime,pickupPoint, dropPoint);
				bookingid++;
				Booking booking = new Booking(bookingid,customerId, pickupPoint, dropPoint, taxiAvailable.getTaxiNumber(),pickupTime);
				int droptime = booking.calculateDropTime(pickupTime, pickupPoint, dropPoint);
				System.out.println(droptime);
				taxiAvailable.updatePickupTime(droptime);
				int amount = booking.calculateEarning(pickupPoint,dropPoint);
				taxiAvailable.updateEarning(amount);
				taxiAvailable.updateLocation(dropPoint);
				booking.printBookingDetails();
				
			
		}
		else {
				System.out.println("No taxi is free at this moment!! Try again later");	
			}
			System.out.println("Press 1 - Continue 0-Stop");
			choice = sc.nextInt();
			
		}
		taxidetails.getTaxiDetails();
		
		// TODO Auto-generated method stub

	}

}
