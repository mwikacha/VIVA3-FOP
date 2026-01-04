package com.guild.market;
/*instance variable double(primitive type) cannot be null, so I add boolean helper isMagicPriceSet
using Double.isNaN(since Double is an object wrapper*/
public class MagicItem {
    //instance variables
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
        /*Double to a double, Java unboxes the object to the primitive. If the argument is null, unboxing throws NullPointerException. */
        this.magicPrice = (magicPrice == null ? Double.NaN : magicPrice.doubleValue()); 
        itemCount++;
    }

    //encapsulation methods
    //getter methods
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

    public static void main(String[] args) {
        // Sample usage (not part of tests)
        MagicItem itemA = new MagicItem(); // default, price not set (NaN)
        System.out.println(itemA.getName());                 // Unnamed Magic Item
        System.out.println(Double.isNaN(itemA.getMagicPrice())); // true
        System.out.println(itemA.isMagicPriceSet());         // false

        itemA.setMagicPrice(100.50);
        System.out.println(itemA.getMagicPrice());           // 100.5
        System.out.println(itemA.isMagicPriceSet());         // true

        MagicItem itemB = new MagicItem("Emotional Damage Potion", 49.99);
        System.out.println(itemB.getName());                 // Emotional Damage Potion
        System.out.println(itemB.getMagicPrice());           // 49.99

        double total = MagicItem.calculateTotal(100.00, 2);
        System.out.printf("%.2f%n", total);            // 226.0

        System.out.println(MagicItem.getItemCount());        // Depends on how many items created so far

    }
}

