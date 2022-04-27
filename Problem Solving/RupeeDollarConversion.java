import java.util.*;

class Rupee {
	double RUPEE_DOLLAR_CONVERSION = 74.28;
	private double amount;
	
	Rupee(double amount) {
		if((int)amount <= 0)
			throw new Error("The amount can't be less than 0");
		else
			this.amount = amount;
	}
	
	public double convertToDollar() {
		return (double)((1/RUPEE_DOLLAR_CONVERSION)* this.amount);
	}
	
	public double getRupee() {
		return this.amount;
	}
	
}

class Dollar {
	double RUPEE_DOLLAR_CONVERSION = 74.28;
	private double amount;
	
	Dollar(double amount) {
		if((int)amount <= 0)
			throw new Error("The amount can't be less than 0");
		else
			this.amount  = amount;
	}
	
	public double convertToRupee() {
		return (double)(RUPEE_DOLLAR_CONVERSION * this.amount);
	}
	
	public double getDollar() {
		return this.amount;
	}
	
}

class Wallet {
	private ArrayList <Rupee> rupee = new ArrayList <Rupee> ();
	private ArrayList <Dollar> dollar = new ArrayList <Dollar> ();
	
	public void addRupee(Rupee addRupee) {
		rupee.add(addRupee);
		printCurrentWallet();
	}
	
	public void addDollar(Dollar addDollar) {
		dollar.add(addDollar);
		printCurrentWallet();
		}	
		
	
	private void printCurrentWallet() {
		System.out.print("Total amount added as Rupees:");
		double totalrupee = 0.0;
		double converttoRupees = 0.0;
		double totaldollar = 0.0;
		double converttoDollar = 0.0;

		for(Rupee rupees : rupee) {
			totalrupee += rupees.getRupee();
			converttoDollar +=  rupees.convertToDollar();
		}
		System.out.println(totalrupee + "INR");
		System.out.print("Total amount added as Dollar:");
		for(Dollar dollars : dollar) {
			totaldollar += dollars.getDollar();
			converttoRupees += dollars.convertToRupee();
		}
		System.out.printf("%.9f",totaldollar);
		System.out.println("");
		System.out.println("Total amount in Rupee:" + (totalrupee+converttoRupees));
		System.out.printf("Total amount in Dollar: %.9f" , (totaldollar + converttoDollar));
		System.out.println("");
	}
}
public class RupeeDollarConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Wallet wallet = new Wallet();
		int choice = 1;
		while(choice != 2) {
			System.out.println("Enter 1 - Add Rupee 2- Add Dollar");
			int input = sc.nextInt();
			try {
				if(input == 1) {
					System.out.println("Enter the amount you want to add to Rupee");
					double rupees = sc.nextDouble();
					Rupee rupee = new Rupee(rupees);
					wallet.addRupee(rupee);
					
				}
				else if(input == 2) {
					System.out.println("Enter the amount you want to add to Dollar");
					double dollars = sc.nextDouble();
					Dollar dollar = new Dollar(dollars);
					wallet.addDollar(dollar);
					
				}
				
				else 
					System.out.println("Please enter the correct option");

				
			}
			catch(Error e) {
				System.out.println("Please enter the valid amount");
			}
			finally {
				System.out.println("Press 1- add 2-stop");
				choice = sc.nextInt();
			}
			
		}
		

	}

}
