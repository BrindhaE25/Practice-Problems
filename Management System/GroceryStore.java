import java.util.*;


class Item {
    private double taxPercentage;
    private String itemCode;
    private String itemName;
    private String type;
    private double unitPrice;

    Item(String itemCode, String itemName, String type, double unitPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.type = type;
        this.unitPrice = unitPrice;
    }

    public void printItem() {
        System.out.println(itemCode + " " + itemName + " " + type + " " + unitPrice);
    }

    public boolean isHaving(String itemCode) {
    	//System.out.println(this.itemCode);
        return itemCode.equals(this.itemCode);
    }

    public double calculatePrice(double quantity) {
        return unitPrice * quantity;
    }

}

class StoreInventoryDetails {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItems(Item item) {
        items.add(item);
    }

    public void printItems() {
    	//System.out.println(items.size());
        for (Item itemiterate : items) {
            itemiterate.printItem();
        }
    }

    public Item getItem(String itemCode) {
    	//System.out.println(items.size());
    		for (Item item : items) {
                if (item.isHaving(itemCode)) {
                	//System.out.println(item.isHaving(itemCode));
                    item.printItem();
                    return item;
                }
            }
    		throw new Error("Item not found");
    	    }
}

class Bill {
    Map<Item, Integer> itemList = new HashMap<>();
   
    public void addItem(String itemCode, int quantity, StoreInventoryDetails storeInventoryDetails) {
        Item item = storeInventoryDetails.getItem(itemCode);
        itemList.put(item, quantity);
    }

    private double totalWithoutDiscount() {
        double totalWithoutDiscount = 0;
        for (Map.Entry<Item, Integer> items: this.itemList.entrySet()) {
        	Item item = items.getKey();
            totalWithoutDiscount += item.calculatePrice(items.getValue());
        }
        return totalWithoutDiscount;
    }

    private double discountPercentage(double totalAmount) {
        // discount logic
    	 if((int)totalAmount >= 1000 && (int)totalAmount < 2000)
    		  return 0.02 * totalAmount;
    	 else
    		  return 0.05 * totalAmount;
    }

    public void print() {
        double totalWithoutDiscount = totalWithoutDiscount();
        double discount = discountPercentage(totalWithoutDiscount);
        double totalWithDiscount = totalWithoutDiscount - (totalWithoutDiscount * (discount / 100));
        System.out.println("totalWithoutDiscount : " + totalWithoutDiscount);
        System.out.println("discount : " + discount);
        System.out.println("totalWithDiscount : " + totalWithDiscount);
    }
}

class GroceryStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        StoreInventoryDetails storeInventoryDetails =  setupInventoryDetails();
        System.out.println("Available Items");
        storeInventoryDetails.printItems();
        System.out.println("Press 1- Add Items 2 - Stop");
        int choice = sc.nextInt();
        sc.nextLine();
        Bill bill = new Bill();
        while (choice != 2) {
            System.out.println("Enter the Item code");
            String itemCode = sc.next();
            sc.nextLine();
            System.out.println("Enter the quantity");
            int quantity = sc.nextInt();
            try {
                bill.addItem(itemCode, quantity,storeInventoryDetails);
            } catch (Error err) {
                System.out.println("Wrong item code....:(");
                continue;
            }
            System.out.println("Press 1- Add Items 2 - Stop");
            sc.nextLine();
            choice = sc.nextInt();
        }
        bill.print();
    }

    private static StoreInventoryDetails setupInventoryDetails() {
        Item coconutoil = new Item("0001", "COCONUT OIL", "EATABLE", 200.00);
        Item rice = new Item("0002", "RICE", "EATABLE", 60.00);
        Item dhal = new Item("0003", "DHAL", "EATABLE", 120.50);
        Item toothpaste = new Item("0004", "TOOTH PASTE", "DAILY USABLE", 45.25);
        Item makeupkit = new Item("0005", "MAKEUP KIT", "COSMETIC", 300.00);

        StoreInventoryDetails storeInventoryDetails = new StoreInventoryDetails();
        storeInventoryDetails.addItems(coconutoil);
        storeInventoryDetails.addItems(rice);
        storeInventoryDetails.addItems(dhal);
        storeInventoryDetails.addItems(toothpaste);
        storeInventoryDetails.addItems(makeupkit);
        return storeInventoryDetails;
    }
    
}

