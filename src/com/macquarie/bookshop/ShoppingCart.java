package com.macquarie.bookshop;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hussein on 2016-07-01.
 */
public class ShoppingCart {



    List<Item> itemList=null;
    private double totalPrice=0;
    private double totalDiscountedPrice =0;

    public double getTotalPrice() {
        return totalPrice;
    }
    public double getTotalDiscountedPrice() { return totalDiscountedPrice;}
    public double getDiscountAmount() { return getTotalPrice()- getTotalDiscountedPrice();}

    public void addItem(Item item) {
        if(this.itemList!=null){
                this.itemList.add(item);
        }else
        {
            this.itemList=new ArrayList();
            this.itemList.add(item);
        }

        totalPrice +=item.getOriginalPrice();


    }


    public void removeItem(Item item) { this.itemList.remove(item);   }

    public List<Item> getItemList() {return itemList;   }



    public void calculateTotalDiscount() {
        this.totalDiscountedPrice =0;
        itemList.forEach( item -> this.totalDiscountedPrice +=item.getOriginalPrice()-item.getDiscount());


    }

    public void applyDiscount(Discount discount){
        discount.applyDiscount(getItemList());

        calculateTotalDiscount();
    }

}
