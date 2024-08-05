import java.util.Scanner;

public class Client implements Menus {
    private String inputClient;

    private final Scanner sCInputClient = new Scanner(System.in);

    protected void buyProducts() {
        productsList();
    }
}