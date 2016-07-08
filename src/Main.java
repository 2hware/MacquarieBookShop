import com.macquarie.bookshop.DistinctPercentageDiscount;
import com.macquarie.bookshop.Item;
import com.macquarie.bookshop.ShoppingCart;

public class Main {

    public static void main(String[] args) {

        ShoppingCart shoppingCart=new ShoppingCart();

        Item item11=new Item(1,8,"Book 1 ");
        Item item21=new Item(2,8,"Book 2 ");
        Item item31=new Item(3,8,"Book 3 ");
        Item item12=new Item(1,8,"Book 1 ");
        Item item22=new Item(2,8,"Book 2 ");
        Item item23=new Item(3,8,"Book 3 ");
        Item item4 =new Item(4,8,"Book 4 ");
        Item item5 =new Item(5,8,"Book 5 ");


        shoppingCart.addItem(item11);
        shoppingCart.addItem(item21);
        shoppingCart.addItem(item31);

        shoppingCart.addItem(item12);
        shoppingCart.addItem(item22);
        shoppingCart.addItem(item23);
        shoppingCart.addItem(item4);
        shoppingCart.addItem(item5);

        DistinctPercentageDiscount distinctPurchasesPercentageDiscount=new DistinctPercentageDiscount();
        shoppingCart.applyDiscount(distinctPurchasesPercentageDiscount);

        System.out.println("Total Original price   :"+shoppingCart.getTotalPrice());
        System.out.println("Total Discounted price :"+shoppingCart.getTotalDiscountedPrice());
        System.out.println("Total Discount         :"+shoppingCart.getDiscountAmount());

    }
}
