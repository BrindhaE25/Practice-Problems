import java.util.*;

class Item {
	String ItemCode;
    String ItemName;
    String Type;
    double UnitPrice;
    
    Item(String ItemCode,String ItemName , String Type, double UnitPrice) {
    	this.ItemCode = ItemCode;
        this.ItemName = ItemName;
        this.Type = Type;
        this.UnitPrice = UnitPrice;
    	
    }
	
}

class Discount {
	int amount;
	int discount;
	
	Discount(int amount, int discount) {
		this.amount = amount;
		this.discount = discount;
	}
	/*public void printDiscount() {
			for(Map.Entry<Integer,Integer> hm : discounts.entrySet())
				System.out.println(hm.getKey() + " " + hm.getValue());
	} */
	
	 
}
	
class StoreInventoryDetails {
	protected ArrayList <Item> items = new ArrayList <Item> ();
	
	public void AddNewItem(Item item) {
		items.add(item);
		//items.add(item);
	}
	
	public void PrintItems() {
		for(Item i : items) {
			System.out.println(i.ItemCode + " " + i.ItemName + " " + i.Type + " " + i.UnitPrice);
		}
		/*Item it = items.get(1);
		System.out.println(it.ItemName + " " + it.Type + " " + it.UnitPrice); */
		
		
			
	}
	
}

class Bill extends StoreInventoryDetails {
	ArrayList <Item> item = new ArrayList <Item> ();
	ArrayList <Double> price = new ArrayList <Double> ();
	ArrayList <Double> quantity = new ArrayList <Double> ();
	ArrayList <Double> tax = new ArrayList <Double> ();

	public void addItem(String itemcode) {
		for(Item itm : super.items)	{
			if(itm.ItemCode.equals(itemcode))
				item.add(itm);
		}
	}
	
	public void addTax(double tax_amnt) {
		tax.add(tax_amnt);
	}
	
	public void printItem(String itemcode) {
			for(Item itm : super.items)	{
			System.out.println("Print Item");
			System.out.println(itm.ItemCode + " " + itm.ItemName + " " + itm.Type + " " + itm.UnitPrice);
			if(itm.ItemCode.equals(itemcode))
				System.out.println(itm.ItemCode + " " + itm.ItemName + " " + itm.Type + " " + itm.UnitPrice);
		}
				
	}
	
	public double calculateprice(String itemcode, double qty) {
		double price = 0.0;
		for(Item itm : super.items)	{
			if(itm.ItemCode.equals(itemcode))
				price = qty * itm.UnitPrice;
		}
		return price;
	}
	
	public void addQuantity(double qty) {
		quantity.add(qty);
	}
	
	public void addPrice(double prce) {
		price.add(prce);
	}
	
	public String gettype(String itemcode) {
		String item_type = "";
		for(Item itm : super.items)	{
			if(itm.ItemCode.equals(itemcode))
				item_type += itm.Type;
		}
		return item_type;
 
	}
	public double calculatediscount(ArrayList <Discount> discount , double total) {
		double amnt=0.0;
		Iterator<Discount> itr = discount.iterator();
		while(itr.hasNext()) {
			Discount d = itr.next();
			if(d.amount < (int)total) {
				amnt = (d.discount/100)*total;	
			}
			
		}
		
		return amnt;		
	}
	
}
	
class Tax {
	HashMap <String ,Integer> gst = new HashMap<String,Integer>();
	
	public void printGST() {
		for(Map.Entry<String,Integer> hm : gst.entrySet())
			System.out.println(hm.getKey() + " " + hm.getValue());
	}
	
	public double calculatetax(String type, double price) {
		int gst_percent = gst.get(type);
		double amount = (gst_percent/100)*price;
		return amount;
	}
}
    
    class GroceryStore {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        double price = 0.0;
        double tax_amount;
        double total_bill = 0.0;
        double total = 0.0;
        double discount_amount = 0.0;
        

    	StoreInventoryDetails sid = new StoreInventoryDetails();
    	Item new_item = new Item("0001","COCONUT OIL", "EATABLE", 200.00);
    	sid.AddNewItem(new_item);
    	new_item = new Item("0002","RICE", "EATABLE",60.00);
    	sid.AddNewItem(new_item);
        new_item = new Item("0003","DHAL", "EATABLE",120.50);
        sid.AddNewItem(new_item);
        new_item = new Item("0004","TOOTH PASTE", "DAILY USABLE",45.25);
        sid.AddNewItem(new_item);
        new_item = new Item("0005","MAKE UP KIT", "COSMETIC",300.00);
        sid.AddNewItem(new_item);
        //sid.PrintItems();
        
        Tax tax = new Tax();
        tax.gst.put("EATABLES", 5);
        tax.gst.put("DAILY USABLE", 8);
        tax.gst.put("COSMETIC" , 15);
        //tax.printGST();
        
        //Discount discount[] = new Discount[2];
        ArrayList <Discount> discount = new ArrayList <Discount> ();
        discount.add(new Discount(1000, 2));
        discount.add(new Discount(2000, 5));

        //discount.printDiscount();
        System.out.println("Item Details");
        sid.PrintItems();
        Bill b = new Bill();
        System.out.println("Press 1- Add 0- Stop");
        int choice = sc.nextInt();
        while(choice != 0) {
        	System.out.println("Enter the item code");
        	String item_code = sc.nextLine();
        	sc.nextLine();
        	b.addItem(item_code);
        	b.printItem(item_code);
        	
        	System.out.println("Enter the quantity");
        	double quantity = sc.nextDouble();
        	b.addQuantity(quantity);
        	price = b.calculateprice(item_code,quantity);
        	b.addPrice(price);
        	String type = b.gettype(item_code);
        	tax_amount = tax.calculatetax(type,price);
        	b.addTax(tax_amount);
        	total_bill +=  price + tax_amount;
        }
        discount_amount = b.calculatediscount(discount, total_bill);
        
        System.out.println(total_bill);
        System.out.println(discount_amount);
        System.out.println(total_bill - discount_amount);
        
        
        
    }
    }