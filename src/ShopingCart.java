import java.util.LinkedList;

public class ShopingCart {
    private String user;
    protected LinkedList<Product> listProductsBuy = new LinkedList<>();

    protected void showShoppingCart() {
        System.out.println(">>> Your Cart " + getUser() + " <<<");

        for (Product iterator : listProductsBuy) {
            System.out.println("    - " + iterator);
        }
    }

    protected void addCart(Product product) {
        listProductsBuy.add(product);

        System.out.println();
        System.out.println("¡Product added to shopping cart!");
    }

    protected void removeCart(Product product) {
        listProductsBuy.remove(product);

        System.out.println();
        System.out.println("¡Product removed from shopping cart!");
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
