import java.util.InputMismatchException;
import java.util.Scanner;

public class StartSystem {
    Scanner sc = new Scanner(System.in);
    int optionUser = 0;

    Store store1 = new Store(">>> Bermudez Tecnology <<<");
    Administrator admin = new Administrator("Andres Bermudez", "Andres@mail.com", "abcd1234");

    public void start() {
        store1.addProducts();

        while(optionUser ==0) {
            admin.welcomeMenu();

            try {
            optionUser = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("¡Remember to choose only from the available options!");
                sc.nextLine();
            }
        }

        switch(optionUser) {
            case 1:
                Customer customer = new Customer();
                customer.buyProducts();
                break;
            case 2:
                admin.verifyAdministrator();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println();
                System.out.println("¡Remember to choose only from the available options!");
                break;
        }
    }
}
