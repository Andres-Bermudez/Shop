import java.util.ArrayList;

public class ShopingCart {
    private static String user;
    protected static ArrayList<Product> listProductsBuy = new ArrayList<>();

    protected static void showShoppingCart() {
        System.out.println();
        System.out.println(">>> Your Cart " + ShopingCart.getUser() + " <<<");

        for (Product iterator : listProductsBuy) {
            System.out.println("    - " + iterator);
        }
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

    public static String getUser() {
        return user;
    }

    public void setUser(String user) {
        ShopingCart.user = user;
    }
}
