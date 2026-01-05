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

/*"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
Quality drops to 0 after the concert */
@Test
void backStagePass_IncreaseQualityWhenMoreThan10Days() {
    Item[] items = new Item[] {
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(14, items[0].sellIn);
    assertEquals(21, items[0].quality); //quality increases by 1 when more than 10 days left
}
@Test
void backStagePass_IncreaseQualityWhen10DaysOrLess() {
    Item[] items = new Item[] {
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(9, items[0].sellIn);
    assertEquals(22, items[0].quality); //quality increases by 2 when 3<days<=10
}
@Test
void backStagePass_IncreaseQualityWhen5DaysOrLess() {
    Item[] items = new Item[] {
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, items[0].sellIn);
    assertEquals(23, items[0].quality); //quality increases by 3 when 0<days<=5
}
@Test
void backStagePass_QualityDropsToZeroAfterConcert() {
    Item[] items = new Item[] {
        new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(-1, items[0].sellIn);//-1 implies day has passed. 0 is still day of 
    assertEquals(0, items[0].quality); //quality drops to 0 after concert
}
}
