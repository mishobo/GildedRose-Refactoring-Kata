package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        // loop through the array
        for (int i = 0; i < items.length; i++) {
            // Backstage passes and Aged Brie increases in quality by day
            // when item is not Aged Brie and Backstage passes to a TAFKAL80ETC concert
            // this part caters for the condition of lowering the quality value by end of day
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // when quality value is greater than zero
                if (items[i].quality > 0) {
                    // when item is not Sulfuras, Hand of Ragnaros
                    // Sulfuras, Hand of Ragnaros never decreases in value
                    // Sulfuras Quality is 80 and it never alters
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        // reduce quality value by 1
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                // item is either Backstage passes or Aged Brie
                // Backstage passes and Aged Brie increases in quality by day
                // quality of an item is never greater than 50
                if (items[i].quality < 50) {
                    // increase quality value
                    items[i].quality = items[i].quality + 1;
                    // when item is Backstage passes to a TAFKAL80ETC concert
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // when sellIn value is 10 and below
                        if (items[i].sellIn < 11) {
                            // when quality is less than 50, increase value
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        // when days to the concert are 5 or less, increase value by 3
                        // quality is never greater than 50
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // lower sellIn value for items apart from Sulfuras as the days go by
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Once sell by date has passed quality degrades twice as fast
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    // if item is Backstage passes and sellIn value is less than zero update quality value to zero
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    // if item is Aged Brie increase quality value
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
