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

            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {

                if (item.name.equals("Aged Brie")) {
                    if (item.quality < 50) {
                        item.quality += 1;
                    }
                } else if (item.name.equals("Backstage passes")) {
                    if (item.quality < 50) {
                        if (item.sellIn < 6) {
                            item.quality += 2;
                        } else if (item.sellIn < 11) {
                            item.quality += 1;
                        }


                    }


                }


            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn -= 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality -= 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality += 1;
                    }
                }
            }
        }
    }
}
