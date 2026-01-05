package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
