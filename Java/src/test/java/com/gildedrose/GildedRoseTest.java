package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

class GildedRoseTest {

@Test
void normalItem_decreasesSellInAndQualityByOne() {
    Item[] items = new Item[] {
        new Item("+5 Dexterity Vest", 10, 20)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(9, items[0].sellIn);
    assertEquals(19, items[0].quality);
}

@Test
void normalItem_afterSellDate_degradesQualityTwiceAsFast() {
    Item[] items = new Item[] {
        new Item("Elixir of the Mongoose", 0, 10) //sellIn =0 means sell by date has passed
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(-1, items[0].sellIn);
    assertEquals(8, items[0].quality);
}

@Test
void qualityNeverNegative() {
    Item[] items = new Item[] {
        new Item("Elixir of the Mongoose", 5, 0)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, items[0].sellIn);
    assertEquals(0, items[0].quality);//quality remains 0 and should not go negative
}

@Test
void agedBrie_increasesQualityOverTime() {
    Item[] items = new Item[] {
        new Item("Aged Brie", 2, 0)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(1, items[0].sellIn);
    assertEquals(1, items[0].quality);
}

@Test
void qualityNeverAboveFifty() {
    Item[] items = new Item[] {
        new Item("Aged Brie", 2, 50)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(1, items[0].sellIn);
    assertEquals(50, items[0].quality); //quality remains 50 and should not go above 50

}

@Test
void sulfuras_neverChanges() {
    Item[] items = new Item[] {
        new Item("Sulfuras, Hand of Ragnaros", 0, 80)//only item with quality 80
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, items[0].sellIn);
    assertEquals(80, items[0].quality); //Sulfuras quality and sellIn never change
}



}
