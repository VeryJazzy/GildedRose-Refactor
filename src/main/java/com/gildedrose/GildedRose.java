package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {

    private List<Item> items;

    public GildedRose(Item[] items) {
        this.items = Arrays.asList(items);
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            item.sellIn -= 1;

            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrieQuality(item);
                    break;
                case "Backstage passes":
                    updateBackstagePassesQuality(item);
                    break;
                case "Conjured":
                    updateRegularItemQuality(item);
                    updateRegularItemQuality(item);
                    break;
                default:
                    updateRegularItemQuality(item);
            }
            checkQualityWithinBounds(item);
        }
    }


    public void updateRegularItemQuality(Item item) {
        if (item.sellIn < 1) {
            item.quality -= 2;
        } else {
            item.quality -= 1;
        }
    }

    public void checkQualityWithinBounds(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

    public void updateBackstagePassesQuality(Item item) {
        if (item.sellIn < 1) {
            item.quality = 0;
        } else if (item.sellIn < 6) {
            item.quality += 3;
        } else if (item.sellIn < 11) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }
    }

    public void updateAgedBrieQuality(Item item) {
        item.quality += 1;
    }


}



