import java.util.*;

class Bill {
	private int itemCode;
	private String itemName;
	private double unitPrice;
	private int quantity;
	private double totalPrice;
	
	Bill(int itemCode , String itemName ,  double unitPrice , int quantity , double totalPrice) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	public void printDetails() {
		System.out.println(this.itemCode + " " + this.itemName + " " + this.unitPrice + " " + this.quantity + " " + this.totalPrice);
	}
}

class TotalBill {
	private static int billid = 1;
	private int billId;
	private int customerId;
	private ArrayList <Bill> bills = new ArrayList <Bill> ();
	private double totalAmount;
	
	TotalBill(int customerId) {
		this.billId = billid++;
		this.customerId = customerId;
	}
	
	public void addBill(Bill bill) {
		bills.add(bill);
	}
	
	public void calculateTotalAmount() {
		Iterator <Bill> it = bills.iterator();
		while(it.hasNext()) {
			Bill bill = it.next();
			this.totalAmount += bill.getTotalPrice();
		}
	}
	
	public void printBillDetails() {
		Iterator <Bill> it = bills.iterator();
		while(it.hasNext()) {
			Bill bill = it.next();
			bill.printDetails();
		}
		System.out.println("Grand Total : " + this.totalAmount);
	}
}
class Customer {
	private static int customerid = 1;
	private int customerId;
	private String customerName;
	private String phoneNo;
	private String address;
	
	Customer(String customerName, String phoneNo, String address) {
		this.customerId = customerid++;
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	
	public String getName() {
		return this.customerName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNo;
	}
	
	public void printCustomerDetails() {
		System.out.println(this.customerId + " " + this.customerName + " " + this.phoneNo + " "+ this.address);
	}
	
	public int getCustomerId() {
		return this.customerId;
	}
}

class CustomerDetails {
	ArrayList <Customer> customers = new ArrayList <Customer> ();
	
	public void addNewCustomer(Customer customer) {
		customers.add(customer);
	}
	
	
	public Customer checkCustomer(String name, String phoneNo) {
		Iterator <Customer> it = customers.iterator();
		while(it.hasNext()) {
			Customer customer = it.next();
			String Name = customer.getName();
			String PhoneNo = customer.getPhoneNumber();
			if(name.equals(Name) && phoneNo.equals(PhoneNo))
				return customer;
			
		}
		return null;
	}
	
	public void printAllCustomers() {
		Iterator <Customer> it = customers.iterator();
		while(it.hasNext()) {
			Customer customer = it.next();
			customer.printCustomerDetails();
		}
		
	}
}

class Item {
	private static int itemcode = 1;
	private int itemCode;
	private String itemName;
	private double unitPrice;
	private int totalQuantity;
	
	Item(String itemName , double unitPrice, int totalQuantity) {
		this.itemCode = itemcode++;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.totalQuantity = totalQuantity;

	}
	
	public void deduceQuantity(int quantity) {
		this.totalQuantity -= quantity;
	}
	
	public void printItemDetails() {
		System.out.println(this.itemCode + " " + this.itemName + " " + this.unitPrice + " " + this.totalQuantity);
	}
	
	public int getItemCode() {
		return this.itemCode;
	}
	
	public void updatePrice(double price) {
		this.unitPrice = price;
	}
	
	public void updateQuantity(int quantity) {
		this.totalQuantity = quantity;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public int checkAvailability(int requiredQuantity) {
		if(this.totalQuantity >= requiredQuantity && this.totalQuantity != 0) 
			return 1;
		else 
			return 0;	
	}
	
	public double calculateAmount(int quantity) {
		return (this.unitPrice * quantity);
	}
	
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	
	
}
class Inventory {
	ArrayList <Item> items = new ArrayList <Item> ();
	
	public void addNewItem(Item item) {
		items.add(item);
	}
	
	public void printAllItems() {
		Iterator <Item> it = items.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			item.printItemDetails();
		}
		
	}
	
	public Item getItem(int itemCode) {
		Iterator <Item> it = items.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			int currentitemcode = item.getItemCode();
			if(currentitemcode == itemCode)
				return item;
		}
		return null;
		
	}
	
	public Item getItem(String itemName) {
		Iterator <Item> it = items.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			String itemname = item.getItemName();
			if(itemname.equals(itemName))
				return item;
		}
		return null;
		
	}
}
public class GroceryStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Inventory inventory = new Inventory();
		Item rice = new Item("RICE",150.00,100);
		inventory.addNewItem(rice);
		Item shampoo = new Item("SHAMPOO", 100.00,200);
		inventory.addNewItem(shampoo);
		Item dhal = new Item("DHAL",200.00,300);
		inventory.addNewItem(dhal);
		Item paste = new Item("TOOTHPASTE",25.50,100);
		inventory.addNewItem(paste);
		
		CustomerDetails customerdetails = new CustomerDetails();
		Customer anil = new Customer("ANIL", "9755345678","1,SAINT ST, CHENNAI-23.");
		customerdetails.addNewCustomer(anil);
		Customer anita = new Customer("ANITA","9123490789","NEW COLONY,CBE-44.");
		customerdetails.addNewCustomer(anita);
		Customer balu = new Customer("BALU","9095678789","SREE APARTMENT,TPR-1");
		customerdetails.addNewCustomer(balu);
		Customer sunith = new Customer("SUNITH","9623467855","GRANDEUR,ERD-9");
		customerdetails.addNewCustomer(sunith);
		
				
		char input = 'y';
		int customerid = 0;
		int calculatedbill = 0;
		TotalBill totalbill = null;
		Customer customer = null;
		String password = "PASSWORD";
		GroceryStore grocerystore = new GroceryStore();
		
		
		while(input == 'y') {
			System.out.println("Please enter v for vendor and c for customer");
			char user = sc.nextLine().charAt(0);
			sc.nextLine();
			if(user == 'v') {
				System.out.println("Please enter your password");
				//sc.nextLine();
				String userpassword = sc.next();
				String decryptedpassword = grocerystore.checkPassword(userpassword);
				System.out.println(decryptedpassword);
				if(decryptedpassword.equals("QBTTXPSE")) {
					System.out.println("Enter 1- Add new Item \n2-Update Price \n3-Update Quantity");
					int choice = sc.nextInt();
					sc.nextLine();
					System.out.println("#####Items already available in the inventory#####");
					inventory.printAllItems();
					if(choice == 1) {
						System.out.println("Enter the Item Name");
						String itemName = sc.next();
						Item itemavailable = inventory.getItem(itemName);
						if(itemavailable == null) {
							System.out.println("Enter the Unit Price (In Double e.g.,100.50)");
							double price = sc.nextDouble();
							System.out.println("Enter the Quantity Available");
							int quantity = sc.nextInt();
							inventory.addNewItem(new Item(itemName,price,quantity));	
						}
						else
							System.out.println("Item already available in the inventory");
											//inventory.printAllItems();	
					}
					else if(choice== 2  || choice == 3) {
						System.out.println("The available items in the store are:");
						inventory.printAllItems();
						System.out.println("Enter the Item Code for which you need to update the Price/Quantity");
						int code = sc.nextInt();
						Item itemToUpdate = inventory.getItem(code);
						if(itemToUpdate == null)
							System.out.println("Please enter the correct Item Code");
						else {
							if(choice == 2) {
								System.out.println("Enter the price that need to be updated");
								double price = sc.nextDouble();
								itemToUpdate.updatePrice(price);
								System.out.println("Item with updated details");
								itemToUpdate.printItemDetails();
								//inventory.printAllItems();		
							}
							else {
								System.out.println("Enter the quantity that need to updated for the selected item");
								int quantity = sc.nextInt();
								itemToUpdate.updateQuantity(quantity);
								System.out.println("Item with updated details");
								itemToUpdate.printItemDetails();
								
							}
							
						}
											
					}
					
					else 
						System.out.println("Please enter the correct choice");
					
					
				}
				else 
					System.out.println("Please enter the correct password");

				System.out.println("Do you wish to continue/stop... Press y to continue any key to stop");
				sc.nextLine();
				input = sc.nextLine().charAt(0);
				
				
			}
			
			else if(user == 'c') {
				System.out.println("Please enter whether you are a new/existing customer... Press n - new customer e- existing");
				//sc.nextLine();
				char customerchoice = sc.nextLine().charAt(0);
				if(customerchoice == 'n') {
					System.out.println("Enter your name");
					//sc.nextLine();
					String name = sc.nextLine();
					//System.out.println(name);
					System.out.println("Enter your Phone Number");
					//sc.nextLine();
					String phoneno = sc.nextLine();
					//System.out.println(phoneno);
					customer = customerdetails.checkCustomer(name, phoneno);
					if(customer == null) {
						System.out.println("Enter your address");
						sc.nextLine();
						String address = sc.next();
						customer = new Customer(name,phoneno,address);
						customerdetails.addNewCustomer(customer);
						customerid = customer.getCustomerId();
						System.out.println("Congratulations!You are added successfully as a customer");
						customerdetails.printAllCustomers();
					}
					else
						System.out.println("You are already an existing customer"); 
				}
					else if(customerchoice == 'e') {
						//System.out.println("Enter your name:")
						System.out.println("Enter your name");
						//sc.nextLine();
						String existingname = sc.nextLine();
						//System.out.println(name);
						System.out.println("Enter your Phone Number");
						//sc.nextLine();
						String existingphoneno = sc.nextLine();
						//System.out.println(phoneno);
						customer = customerdetails.checkCustomer(existingname, existingphoneno);
						if(customer != null) {
							System.out.println("Do you wish to purchase a product.. Press y - yes n- no");
							char userpurchasechoice = sc.nextLine().charAt(0);
							while(userpurchasechoice == 'y') {
								System.out.println("######Items available in the inventory######");
								inventory.printAllItems();
								System.out.println("Enter the code of the item you need to purchase (In Numbers)");
								int itemcode = sc.nextInt();
								Item itemToBePurchased = inventory.getItem(itemcode);
								if(itemToBePurchased != null) {
									System.out.println("Enter the quantity required");
									int quantity = sc.nextInt();
									int result = itemToBePurchased.checkAvailability(quantity);
									if(result == 1) {
										double amount = itemToBePurchased.calculateAmount(quantity);
										itemToBePurchased.deduceQuantity(quantity);
										Bill bill = new Bill(itemcode, itemToBePurchased.getItemName(),itemToBePurchased.getUnitPrice(),quantity,amount);
										if(calculatedbill == 0) {
											totalbill = new TotalBill(customerid);
						
										}
										
										totalbill.addBill(bill);
										calculatedbill++;
										
									}
									else 
										System.out.println("The Quantity you entered is not available... Sorry for the inconvenience..");
								}
								else
									System.out.println("Please enter the correct item code");
								
								System.out.println("Do you wish to continue/stop.. Press y-continue n-stop");
								sc.nextLine();
								userpurchasechoice = sc.nextLine().charAt(0);
								System.out.println(userpurchasechoice + " hello");
								
								}
							System.out.println("hi");
							totalbill.calculateTotalAmount();
							totalbill.printBillDetails();
					
							
						}
						
						else
							System.out.println("Sorry.. You are not an existing customer... Kindly register");

							
				}
					else
						System.out.println("Please enter the correct input");
				
				System.out.println("Do you wish to continue/stop... Press y to continue any key to stop");
				sc.nextLine();
				input = sc.nextLine().charAt(0);

				
				
				
			}
			

			
		}
		
	}
	
	public String checkPassword(String password) {
		String decryptedpassword = "";
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i) == 'Z')
				decryptedpassword += (char)((int)password.charAt(i) - 25);
			else
				decryptedpassword += (char)((int)password.charAt(i) + 1);
		}
		return decryptedpassword;
	}

}
