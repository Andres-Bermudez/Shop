import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int optionUser = 0;

        Store store1 = new Store(">>> Bermudez Tecnology <<<");
        store1.addProducts();

        Administrator admin = new Administrator("Andres Bermudez", "Andres@mail.com", "abcd1234");

        while (true) {
            admin.welcomeMenu();

            try {
                optionUser = sc.nextInt();

            } catch (NumberFormatException e) {
                System.out.println("¡Remember to choose only from the available options!");
            }

            switch (optionUser) {
                case 1:
                    Client client = new Client();
                    client.buyProducts();
                    break;
                case 2:
                    admin.verifyAdministrator();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("¡Remember to choose only from the available options!");
            }
        }
    }
}