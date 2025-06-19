package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @DisplayName("nameStaysTheSameWhenUpdatingQuality")
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", app.items[0].name);
    }

    @DisplayName("lower sellIn at the end of day")
    @Test
    void testUpdateQuality_whenDayEnds_sellInLowersEachDay(){
        Item[] items = new Item[] { new Item("foo", 15, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
    }

    @DisplayName("lower quality at the end of day")
    @Test
    void testUpdateQuality_whenDayEnds_qualityLowers(){
        Item[] items = new Item[] { new Item("foo", 15, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }


    @DisplayName("quality degrades twice as fast after sellIn date passes")
    @Test
    void testUpdateQuality_whenSellByDatePasses_qualityDegradesTwiceAsFast(){
        Item[] items = new Item[] { new Item("foo", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }

    @DisplayName("quality is never a negative")
    @Test
    void testUpdateQuality_whenQualityIsZero_shouldNotBeNegative(){
        Item[] items = new Item[] { new Item("foo", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @DisplayName("Aged Brie increases in quality the older it gets")
    @Test
    void testUpdateQuality_whenItemIsAgedBrie_IncreasesQualityWhenOlder(){
        Item[] items = new Item[] { new Item("Aged Brie", 4, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
    }

    @DisplayName("Quality of an item is never greater than 50")
    @Test
    void testUpdateQuality_whenAgedBrieValueIs50_qualityValueIsNeverGreaterThan50(){
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @DisplayName("Sulfuras quality does not change")
    @Test
    void testUpdateQuality_WhenItemIsSulfuras_QualityDoesNotChange (){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testUpdateQuality_whenItemIsBackstagePasses_QualityIncreasesTowardsSellInValue(){
        // arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20) };
        GildedRose app = new GildedRose(items);

        // act
        app.updateQuality();

        // assert
        assertEquals(21, app.items[0].quality);

    }

    @Test
    void testUpdateQuality_whenThereAre10DaysForBackstagePasses_QualityIncreasesByTwo(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void testUpdateQuality_whenThereAre3DaysForBackstagePasses_QualityIncreasesByThree(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }


}
