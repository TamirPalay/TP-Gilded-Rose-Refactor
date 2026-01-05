package com.gildedrose;

class GildedRose {
    Item[] items;

    // CHANGED: Extracted item names into constants (removes "magic strings" and prevents typos)
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            // CHANGED: Replaced hard-coded strings with constants (clearer + safer)
            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACKSTAGE)) {

                if (items[i].quality > 0) {
                    if (!items[i].name.equals(SULFURAS)) {
                        // CHANGED: Used helper to decrease quality (removes duplication)
                        decreaseQuality(items[i]);
                    }
                }

            } else {
                // CHANGED: Used helper to increase quality (removes duplication)
                increaseQuality(items[i]);

                if (items[i].name.equals(BACKSTAGE)) {
                    if (items[i].sellIn < 11) {
                        increaseQuality(items[i]);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQuality(items[i]);
                    }
                }
            }

            if (!items[i].name.equals(SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(AGED_BRIE)) {
                    if (!items[i].name.equals(BACKSTAGE)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(SULFURAS)) {
                                decreaseQuality(items[i]);
                            }
                        }
                    } else {
                        // Left as-is for now (maybe implement a helper later if needed)
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    increaseQuality(items[i]);
                }
            }
        }
    }

    // CHANGED: Extracted "increase quality (max 50)" rule into one place
    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    // CHANGED: Extracted "decrease quality (min 0)" rule into one place
    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
