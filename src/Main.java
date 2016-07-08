import com.macquarie.bookshop.DistinctPurchasesPercentageDiscount;
import com.macquarie.bookshop.Item;
import com.macquarie.bookshop.ShoppingCart;

public class Main {

    public static void main(String[] args) {

        ShoppingCart shoppingCart=new ShoppingCart();

        Item item1=new Item(1,8,"Book 1 ");
        Item item2=new Item(1,8,"Book 2 ");
        Item item3=new Item(1,8,"Book 3 ");
        Item item4=new Item(1,8,"Book 4 ");
        Item item5=new Item(1,8,"Book 5 ");
        Item item6=new Item(1,8,"Book 3 ");
        Item item7=new Item(1,8,"Book 4 ");
        Item item8=new Item(5,8,"Book 5 ");
        Item item9=new Item(6,8,"Book 5 ");
        Item item10=new Item(5,8,"Book 5 ");


        shoppingCart.addItem(item1);
//        shoppingCart.addItem(item2);
//        shoppingCart.addItem(item3);
//        shoppingCart.addItem(item4);
//       shoppingCart.addItem(item5);
//        shoppingCart.addItem(item6);
//        shoppingCart.addItem(item7);
//        shoppingCart.addItem(item8);
//      //  shoppingCart.addItem(item9);
////        shoppingCart.addItem(item10);


        DistinctPurchasesPercentageDiscount distinctPurchasesPercentageDiscount=new DistinctPurchasesPercentageDiscount();
        shoppingCart.applyDiscount(distinctPurchasesPercentageDiscount);

        System.out.println("Total Original price   :"+shoppingCart.getTotalPrice());
        System.out.println("Total Discounted price :"+shoppingCart.getTotalDiscountedPrice());
        System.out.println("Total Discount         :"+shoppingCart.getDiscountAmount());

    }
}
