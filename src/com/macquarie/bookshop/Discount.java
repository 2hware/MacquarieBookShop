package com.macquarie.bookshop;

import java.util.List;

/**
 * Created by Hussein on 2016-07-01.
 */
public interface Discount {

    void applyDiscount(List<Item> itemList);
}
