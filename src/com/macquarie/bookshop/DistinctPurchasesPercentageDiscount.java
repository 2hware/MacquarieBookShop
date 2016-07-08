package com.macquarie.bookshop;

import java.io.FileInputStream;
import java.util.*;

/**
 * Created by Hussein on 2016-07-01.
 */
public class DistinctPurchasesPercentageDiscount implements Discount {

    Properties properties;
    List<DistinctPurchasesPercentageDiscountRule> distinctPurchasesPercentageDiscountRules;

    public DistinctPurchasesPercentageDiscount() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("resources//distinct-purchases-percentage-discount.properties"));
            generateRules();


        } catch (Exception e) {

        }
    }

    private void generateRules() {
        distinctPurchasesPercentageDiscountRules = new ArrayList<>();
        Iterator i = properties.values().iterator();

        while (i.hasNext()) {

            String s = (String) i.next();
            String[] ss = s.split(",");
            distinctPurchasesPercentageDiscountRules.add(new DistinctPurchasesPercentageDiscountRule(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2])));
        }
        Collections.sort(distinctPurchasesPercentageDiscountRules);
    }


    @Override
    public void applyDiscount(List<Item> itemList) {
        itemList.forEach(item -> item.resetDiscount());
        for (DistinctPurchasesPercentageDiscount.DistinctPurchasesPercentageDiscountRule distinctPurchasesPercentageDiscountRule : this.distinctPurchasesPercentageDiscountRules) {
            if (!(distinctPurchasesPercentageDiscountRule.count > itemList.size())) {
                while (itemList.stream().filter(item -> !item.isDiscounted()).distinct().count() >= distinctPurchasesPercentageDiscountRule.count) {
                    itemList.stream().filter(item -> !item.isDiscounted()).distinct().limit(distinctPurchasesPercentageDiscountRule.count).forEach(item -> item.applyDiscount(distinctPurchasesPercentageDiscountRule.percentage));
                }
            }
        }
    }

    class DistinctPurchasesPercentageDiscountRule implements Comparable<DistinctPurchasesPercentageDiscountRule> {

        int priority;
        int count;
        int percentage;

        public DistinctPurchasesPercentageDiscountRule(int priority, int count, int percentage) {
            this.priority = priority;
            this.count = count;
            this.percentage = percentage;
        }

        @Override
        public int compareTo(DistinctPurchasesPercentageDiscountRule distinctPurchasesPercentageDiscountRule) {
            return Integer.compare(this.priority, distinctPurchasesPercentageDiscountRule.priority);
        }
    }

}



