import java.util.ArrayList;

public class ShopingCart {
    protected static ArrayList<Product> listProductsBuy = new ArrayList<>();

    protected static void showShoppingCart() {
        System.out.println();
        System.out.println(">>> Your Cart <<<");

        System.out.println();
        for (Product iterator : listProductsBuy) {
            System.out.println("    - " + iterator);
        }
        System.out.println();
    }

    protected void addCart(Product product) {
        listProductsBuy.add(product);

        System.out.println();
        System.out.println("¡Product added to cart!");
    }

    protected static void removeCart(Product product) {
        listProductsBuy.remove(product);

        System.out.println();
        System.out.println("¡Product removed from cart!");
    }
}
