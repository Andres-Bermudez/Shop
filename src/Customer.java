import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer implements Menus {
    private int customerElectionCategory = 0;
    private int customerElectionIDproduct = 0;

    protected void buyProducts() {
        Scanner sc = new Scanner(System.in);

        do {
            productsList();
            try {
                customerElectionCategory = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("¡Remember to choose only from the available options!");
            }

            if (customerElectionCategory < 0 || customerElectionCategory > 5) {
                System.out.println("¡Remember to choose only from the available options!");
            }
        } while (customerElectionCategory < 0 || customerElectionCategory > 5);

        switch (customerElectionCategory) {
            case 0:
                StartSystem obj = new StartSystem();
                obj.start();
                break;
            case 1:
                cellphonesList();
                confirmPurchase();
                break;
            case 2:
                laptopList();
                confirmPurchase();
                break;
            case 3:
                televisionsList();
                confirmPurchase();
                break;
            case 4:
                fridgesList();
                confirmPurchase();
                break;
            case 5:
                whashingMachinesList();
                confirmPurchase();
                break;
            default:
                System.out.println("¡Remember to choose only from the available options!");
                break;
        }
    }

    private void confirmPurchase() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("ID of the product you are going to buy: ");
            try {
                customerElectionIDproduct = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("¡Remember to choose only from the available options!");
            }
        } while (customerElectionIDproduct == 0);

        switch (customerElectionCategory) {
            case 1:
                if (customerElectionIDproduct <= Store.cellPhones.size()) {

                }
                break;
            case 2:
                if (customerElectionIDproduct <= Store.laptops.size()) {

                }
                break;
            case 3:
                if (customerElectionIDproduct <= Store.televisions.size()) {

                }
                break;
            case 4:
                if (customerElectionIDproduct <= Store.fridges.size()) {

                }
                break;
            case 5:
                if (customerElectionIDproduct <= Store.washingMachines.size()) {

                }
                break;
            default:
                break;
        }
    }
}