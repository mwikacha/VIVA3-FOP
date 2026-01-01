/*instance variable double(primitive type) cannot be null, so I add boolean helper isMagicPriceSet
using Double.isNaN(since Double is an object wrapper*/
public class MagicItem {
    //instance variables
    //set to private for security (encapsulation)
    private String name;
    private double magicPrice;

    //static variables
    private static final double MAGIC_TAX_RATE = 0.13;
    private static int itemCount = 0;

    //no argument constructor
    public MagicItem() {
        this.name = "Unnamed Magic Item";
        this.magicPrice = Double.NaN; //to indicate not set
        itemCount++;
    }

    //parameterized constructor
    //receives name and magicPrice
    public MagicItem(String name, Double magicPrice) {
        this.name = name;
        setMagicPrice(magicPrice); //use setter to leverage validation
        itemCount++;
    }

    //getter = only read the value
    //setter = can change the value

    //encapsulation methods
    //getter methods
    //getter only returns the value.
    //getName method
    public String getName() {
        return name;
    }

    //getMagicPrice method
    public double getMagicPrice() {
        return magicPrice;
    }

    public void setMagicPrice(Double magicPrice) {
        if (magicPrice != null && magicPrice < 0)  {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        this.magicPrice = magicPrice;
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

    public boolean isMagicPriceSet() {
        return !Double.isNaN(magicPrice);
    }
}




