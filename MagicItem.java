public class MagicItem {
    //instance variables
    //set to private for security (encapsulation)
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
    public Double getMagicPrice() {
        return magicPrice;
    }

    //setter methods
    //setter validates input to prevent invalid object state.
    //setName method
    //if name is changed,it simply assigns the new value, basically changing the name.
    //item.setName("Health Potion");
    public void setName(String name) {
        this.name = name;
    }

    //setMagicPrice method
    //same as above, but with validation
    //can change price, but cannot be negative.
    public void setMagicPrice(Double magicPrice) {
        //allow null, only reject negative values
        if (magicPrice != null && magicPrice < 0) {
            IllegalArgumentException e = new IllegalArgumentException("Price cannot be negative!");
            throw e;
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
}




