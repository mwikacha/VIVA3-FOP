package com.guild.inventory;
import java.util.List;

public class MagicInventoryItem {
    //###########################################################################################//
    // Instance Variables (Encapsulated)

    private String itemId;  // Unique identifier for the item
    private Integer stock;      // Stock quantity (null indicates not yet in inventory)

    // Static Variables

    private static final int MAX_STOCK = 1000;
    private static int totalItems = 0;

    //###########################################################################################//

    // Constructors

    // 1. No-argument constructor

    protected MagicInventoryItem()
    {
        this.itemId = "Unnamed Magic Item";
        this.stock = null;
        totalItems ++;
    }

    // 2. Parameterized constructor

    protected MagicInventoryItem(String itemID, Integer stock)
    {
        this.setItemId(itemID);

        if(stock == null)
        {
            this.stock = null;
        }
        else
        {
            if(stock > MAX_STOCK)
            {
                stock = MAX_STOCK;
            }
            this.setStock(stock);
        }

        totalItems ++;
    }

    //###########################################################################################//

    // Encapsulation Methods

    // Accessor method

    // 1. get item ID
    
    protected String getItemId()
    {
        return this.itemId;
    }

    // 2. get stock quantity

    protected Integer getStock()
    {
        return this.stock;
    }

    // Mutator method

    // 1. set item ID

    protected void setItemId(String itemId)
    {
        // as required 
        if (itemId == null || itemId.trim().isEmpty())
        {
            throw new IllegalArgumentException("Item ID cannot be empty");
        }

        this.itemId = itemId;
    }

    // 2. set stock quantity

    protected void setStock(int stock)
    {
        if (stock < 0 || stock > MAX_STOCK)
        {
            throw new IllegalArgumentException( "Stock is out of range (0 to " + MAX_STOCK + ")");
        }

        this.stock = stock;
        
    }

    //###########################################################################################//

    // Class Methods

    // 1. get total number of inventory items created

    protected static int getTotalItems()
    {
        return totalItems;
    }

    // 2. calculate total number of stock

    protected static Integer calculateTotalStock(List<MagicInventoryItem> items)
    {
        Integer totalStock = 0;
        if (items == null || items.isEmpty())
        {
            return null;
        }
        for (MagicInventoryItem item : items)
        {
            if(item.getStock() != null)
            {
                totalStock += item.getStock();
            }
        }
        return totalStock;
    }

}


