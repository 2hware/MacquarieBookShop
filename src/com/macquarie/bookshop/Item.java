package com.macquarie.bookshop;

/**
 * Created by Hussein on 2016-07-01.
 */
public class Item {

    private final int id;
    private double originalPrice;
    private double discount;

    String description;

    public Item (int id, double originalPrice,  String description) {

        this.id=id;
        this.originalPrice =originalPrice;
        this.discount=0;
        this.description=description;
    }

    public int getId() {
        return id;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscountedPrice() {
        return getOriginalPrice()-getDiscount();
    }

    public double getDiscount( ) {
       return  this.discount ;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDiscounted() {
        return getDiscountedPrice()<getOriginalPrice();

    }
    public void resetDiscount(){   setDiscount(0);  }

    public void applyDiscount(int percentage)
    {
        setDiscount(getOriginalPrice()*percentage/100);
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Item) {
            Item anotherItem = (Item)anObject;
            if((this.getId()==anotherItem.getId()))
                return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
            return this.getId();
    }

}
