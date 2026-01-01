package com.guild.market.MagicItemTest;
import com.guild.market.MagicItem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MagicItemTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void incrementCount_with_no_arguments()
    {
        int before = MagicItem.getItemCount();

        MagicItem item = new MagicItem();

        assertEquals("Unnamed Magic Item", item.getName());

        assertTrue("Default magicPrice should be null (not set)", Double.isNaN(item.getMagicPrice()));

        assertEquals("Item count should increment by 1", before + 1, MagicItem.getItemCount());
    }

    @Test
    public void incrementCount_with_parameters() {
        int before = MagicItem.getItemCount();

        MagicItem item = new MagicItem("Emotional Damage Potion",49.99);

        assertEquals("Emotional Damage Potion",item.getName());
        assertEquals(49.99, item.getMagicPrice(), 1e-9);
        assertEquals(before + 1, MagicItem.getItemCount());
    }

    @Test
    public void setMagicPrice(){
        MagicItem item = new MagicItem();

        item.setMagicPrice(100.50);

        assertEquals(100.50, item.getMagicPrice(), 1e-9);
        assertTrue(item.isMagicPriceSet());
    }

    @Test
    public void setMagicPrice_with_Neg_value() {
        MagicItem item = new MagicItem();

        try {
            item.setMagicPrice(-1.0);
            fail("Expected IllegalArgumentException for Neg. value");
        } catch (IllegalArgumentException e) {
            assertEquals("Price cannot be negative!", e.getMessage());
        }
    }

    @Test
    public void calculateTotal_with_Tax() {
        double total = MagicItem.calculateTotal(100.00, 2);
        assertEquals(226.00, total, 1e-9);
    }

    @Test
    public void calculateTotal_with_zero() {
        double total = MagicItem.calculateTotal(210.40, 0);
        assertEquals(0.0, total, 1e-9);
    }

    @Test
    public void getItemCount_with_multiple_items() {
        int before = MagicItem.getItemCount();

        new MagicItem();
        new MagicItem("Invisibility Cloak", 150.00);
        new MagicItem("Flying Broomstick", 200.00);

        assertEquals(before + 3, MagicItem.getItemCount());
    }
}
