public class MagicItem {
    //instance variables
    private String name;
    private Double magicPrice;

    //static variables
    private static final double MAGIC_TAX_RATE = 0.13;
    private static int itemCount = 0;

    //no argument constructor
    public MagicItem() {
        this.name = "Unnamed Magic Item";
        this.magicPrice = null;
        itemCount++;
    }

    //parameterized constructor
    //receives name and magicPrice
    public MagicItem(String name, Double magicPrice) {
        this.name = name;
        this.magicPrice = magicPrice;
        itemCount++;
    }

    //encapsulation methods
    //getter methods
    //getName method
    public String getName() {
        return name;
    }

    //getMagicPrice method
    public Double getMagicPrice() {
        if (magicPrice < 0){
            IllegalArgumentException e = new IllegalArgumentException("Price cannot be negative.");
            throw e;
        }
        return magicPrice;
    }

    //static method to get itemCount()
    public static int getItemCount(){
        return itemCount; //no object reference needed for static method, simply return static variable
    }

    //calculateTotalPrice method
    public static double calculateTotal(double magicPrice, int quantity) {
        double totalPricewithTax = magicPrice * quantity * (1 + MAGIC_TAX_RATE);
        return totalPricewithTax;
    }
}

