package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void qualityAndSellInSubtracts() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("reg", 3,3),
            new Item("reg", -4,10),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).sellIn).isEqualTo(2);
        assertThat(app.getItems().get(0).quality).isEqualTo(2);
        assertThat(app.getItems().get(1).sellIn).isEqualTo(-5);
    }

    @Test
    void qualityDegradesX2OnceSellInPassed() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("reg", -1,5),
            new Item("reg", -5,1),
            new Item("reg", 0,6),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).quality).isEqualTo(3);
        assertThat(app.getItems().get(1).quality).isEqualTo(0);
        assertThat(app.getItems().get(2).quality).isEqualTo(4);
    }

    @Test
    void qualityIsNotNegative() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("reg", -1,1),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).sellIn).isEqualTo(-2);
        assertThat(app.getItems().get(0).quality).isEqualTo(0);
    }

    @Test
    void agedBrieQualityIncreases() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("Aged Brie", 10,5),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).sellIn).isEqualTo(9);
        assertThat(app.getItems().get(0).quality).isEqualTo(6);
    }

    @Test
    void QualityNeverMoreThan50() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("Aged Brie", 10,50),
            new Item("Aged Brie", 10,49),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).quality).isEqualTo(50);
        assertThat(app.getItems().get(1).quality).isEqualTo(50);
    }

    @Test
    void sulfurasStaysTheSame() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 10,10),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).sellIn).isEqualTo(10);
        assertThat(app.getItems().get(0).quality).isEqualTo(10);
    }

    @Test
    void backstagePassesIncrease1WhenMoreThan10Days() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("Backstage passes", 11,10),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).sellIn).isEqualTo(10);
        assertThat(app.getItems().get(0).quality).isEqualTo(11);
    }

    @Test
    void backstagePassesIncrease2When10daysOrLess() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("Backstage passes", 10,10),
            new Item("Backstage passes", 6,10),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).quality).isEqualTo(12);
        assertThat(app.getItems().get(1).quality).isEqualTo(12);
    }

    @Test
    void backstagePassesIncrease3When5To0days() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("Backstage passes", 5,10),
            new Item("Backstage passes", 1,10),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).quality).isEqualTo(13);
        assertThat(app.getItems().get(1).quality).isEqualTo(13);
    }

    @Test
    void backstagePassesQuality0AfterSellInPassed() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("Backstage passes", 0,10),
            new Item("Backstage passes", -1,10),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).quality).isEqualTo(0);
        assertThat(app.getItems().get(1).quality).isEqualTo(0);
    }

    @Test
    void conjuredDegradeX2() {
        GildedRose app = new GildedRose(new Item[] {
            new Item("Conjured", 10,10),
            new Item("Conjured", 0,10),
            new Item("Conjured", -5,10),
        });
        app.updateQuality();
        assertThat(app.getItems().get(0).quality).isEqualTo(8);
        assertThat(app.getItems().get(1).quality).isEqualTo(6);
        assertThat(app.getItems().get(2).quality).isEqualTo(6);

    }


}
