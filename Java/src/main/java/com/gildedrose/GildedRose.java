package com.gildedrose;

class GildedRose {

    Item[] items;

    // dependency injection using constructor method
    public GildedRose(Item[] items) {
        this.items = items;
    }

    // update quality method
    public void updateQuality() {

        // loop through the array
        for (Item item : items) {
            // Backstage passes and Aged Brie increases in quality by day
            // when item is not Aged Brie and Backstage passes to a TAFKAL80ETC concert
            // this part caters for the condition of lowering the quality value by end of day
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // when quality value is greater than zero
                if (item.quality > 0) {
                    // when item is not Sulfuras, Hand of Ragnaros
                    // Sulfuras, Hand of Ragnaros never decreases in value
                    // Sulfuras Quality is 80 and it never alters
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        // reduce quality value by 1
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                // item is either Backstage passes or Aged Brie
                // Backstage passes and Aged Brie increases in quality by day
                // quality of an item is never greater than 50
                if (item.quality < 50) {
                    // increase quality value
                    item.quality = item.quality + 1;
                    // when item is Backstage passes to a TAFKAL80ETC concert
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // when sellIn value is 10 and below
                        if (item.sellIn < 11) {
                            // when quality is less than 50, increase value
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        // when days to the concert are 5 or less, increase value by 3
                        // quality is never greater than 50
                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            // lower sellIn value for items apart from Sulfuras as the days go by
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Once sell by date has passed quality degrades twice as fast
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    // if item is Backstage passes and sellIn value is less than zero update quality value to zero
                    } else {
                        item.quality = 0;
                    }
                } else {
                    // if item is Aged Brie increase quality value
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
