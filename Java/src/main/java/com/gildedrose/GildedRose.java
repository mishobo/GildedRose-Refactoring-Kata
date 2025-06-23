package com.gildedrose;


// code smells:- design principles violations
// 1. long function
// 2. Duplicate code

// tech debt:- cost of reworking a code base due to picking the easy way than optimal one

// solution:
// 1. write unit tests to avoid breaking the application when refactoring
// 2. use enhanced for loop for simplicity and readability
// 3. conditional statements for readability up top
// 4. extract duplicate
// 5. Practice SOLID principles
// 6. S - Single responsibility
// 7. O - Open for extension close for modification
// 8. L - Liskov law of substitution
// 9. I - Interface Segregation
// 10. D - Dependency Inversion

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            boolean isAgedBrie = item.name.equals("Aged Brie");
            boolean isBackStage = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
            boolean isConjured = item.name.equals("Conjured Mana Cake");


            if (!isAgedBrie && !isBackStage) {
                if (item.quality > 0) {
                    if (!isSulfuras) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    if (isBackStage) {
                        if (item.sellIn < 11) {
                            item.quality = item.quality + 1;
                        }
                        if (item.sellIn < 6) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
            if (!isSulfuras) {
                item.sellIn = item.sellIn - 1;
            }
            if (item.sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackStage) {
                        if (item.quality > 0) {
                            if (!isSulfuras) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}





