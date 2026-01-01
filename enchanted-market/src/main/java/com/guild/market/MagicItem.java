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
    //1.A new object is created
    //2.Name is set to "Unnamed Magic Item"
    //Price is set to NaN
    public MagicItem() {
        this.name = "Unnamed Magic Item";
        this.magicPrice = Double.NaN; //to indicate not set , Not a Number,This number is invalid / not available / not set, if set to null it will cause error
        //nan replaces the null
        itemCount++;
    }

    //parameterized constructor
    //receives name and magicPrice
    //Double magicPrice to allow null input, bcs input from outside may be null
    //new MagicItem("Potion", null); // now allowed
    //if not, (if uses double) it will cause error since primitive double cannot be null

    //1.A new object is created
    //2.Name is set to input name
    //3.setMagicPrice() is called
    //4.Validation happens inside setter
    //5.itemCount is incremented
    public MagicItem(String name, Double magicPrice) {
        this.name = name;
        setMagicPrice(magicPrice); //use setter to leverage validation before setting value
        itemCount++;
    }

    //getter = only read the value
    //setter = can change the value

    //encapsulation methods
    //getter methods
    //getter only returns the value.
    //returns whatever is inside
    //getName method
    public String getName() {
        return name;
    }

    //getMagicPrice method
    public double getMagicPrice() {
        return magicPrice;
    }

    //setter methods
    //1. Someone tries to change the price
    //2. If the value exists AND is negative → reject
    //3. Otherwise → accept
    public void setMagicPrice(Double magicPrice) {
        //if value exists and is negative, throw exception error
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

    //since we cant check null anymore,we add a helper method to check if magicPrice is set
    //if magicPrice is not NaN, then it is set, this will return true, can safely use.
    public boolean isMagicPriceSet() {
        return !Double.isNaN(magicPrice);
    }
}




