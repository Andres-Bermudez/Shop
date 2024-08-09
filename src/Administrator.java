import java.util.Scanner;

public class Administrator implements Menus {
    protected static String  nameAdministrator;
    protected static String passwordAdministrator;

    private String inputAdministrator;

    private final Scanner sCInputAdministrator = new Scanner(System.in);

    protected Administrator(String nameAdministrator, String passwordAdministrator) {
        Administrator.nameAdministrator = nameAdministrator;
        Administrator.passwordAdministrator = passwordAdministrator;
    }

    protected void verifyAdministrator() {
        String supposedNameAdministrator;
        String supposedPasswordAdministrator;

        System.out.println();
        System.out.print("Enter your email: ");
        supposedNameAdministrator = sCInputAdministrator.nextLine();

        System.out.print("Enter your password: ");
        supposedPasswordAdministrator = sCInputAdministrator.nextLine();

        if (supposedNameAdministrator.equals(nameAdministrator) &&
                supposedPasswordAdministrator.equals(passwordAdministrator)) {

            administratorMenu();

        } else {
            System.out.println();
            System.out.println("¡Authentication Error!");
        }
    }

    private void administratorMenu() {
        do {
            System.out.println();
            System.out.println("Welcome Administrator: " + nameAdministrator);
            System.out.println("   1. Show products.");
            System.out.println("   2. Modify product.");
            System.out.println("   3. Add products.");
            System.out.println("   4. Delete product.");
            System.out.println("   0. Return");
            System.out.print("Your Choice: ");

            inputAdministrator = sCInputAdministrator.nextLine();

            switch (inputAdministrator) {
                case "0":
                    System.out.println();
                    System.out.println("¡Correct closed session!");
                    break;
                case "1":
                    showProducts();
                    break;
                case "2":
                    modifyProduct();
                    break;
                case "3":
                    addProduct();
                    break;
                case "4":
                    deleteProduct();
                    break;
                default:
                    System.out.println("¡Remember to choose only from the available options!");
                    break;
            }
        } while (!inputAdministrator.equals("0"));
    }

    private void showProducts() {
        productsList();
        inputAdministrator = sCInputAdministrator.nextLine();

        switch (inputAdministrator) {
            case "1":
                cellphonesList();
                break;
            case "2":
                laptopList();
                break;
            case "3":
                televisionsList();
                break;
            case "4":
                fridgesList();
                break;
            case "5":
                whashingMachinesList();
                break;
            default:
                System.out.println("¡Remember to choose only from the available options!");
        }
    }

    private void modifyProduct() {
        int productCategory = 0;
        int idProduct = 0;

        do {
            System.out.println();
            System.out.println("Modifying product...");
            System.out.print("Choose the category to which the product to be modified belongs: ");

            try {
                productCategory = sCInputAdministrator.nextInt();

                switch (productCategory) {
                    case 1:
                        cellphonesList();
                        break;
                    case 2:
                        laptopList();
                        break;
                    case 3:
                        televisionsList();
                        break;
                    case 4:
                        fridgesList();
                        break;
                    case 5:
                        whashingMachinesList();
                        break;
                    default:
                        System.out.println("¡Remember to choose only from the available options!");
                }
            } catch (NumberFormatException e) {
                System.out.println("¡Remember to choose only from the available options!");
            }
        } while(productCategory == 0);

        do {
            System.out.println();
            System.out.print("Choose the product: ");

            try {
                idProduct = sCInputAdministrator.nextInt();

                if (idProduct <= Store.products.size()) {
                    System.out.print("New name: ");
                    String newName = sCInputAdministrator.nextLine();

                    System.out.print("New Price: ");
                    String newPrice = sCInputAdministrator.nextLine();

                    if (productCategory == 1) {

                    }

                } else {
                    System.out.println("¡Remember to choose only from the available options!");
                }

            } catch (NumberFormatException e) {
                System.out.println("¡Remember to choose only from the available options!");
            }
        } while(idProduct == 0);

    }

    private void addProduct() {
        System.out.println();
        System.out.println("Adding a product...");
        System.out.print("Name product: ");
        inputAdministrator = sCInputAdministrator.nextLine();

        System.out.print("Product price: ");
        inputAdministrator = sCInputAdministrator.nextLine();
    }

    private void deleteProduct() {
        System.out.println();
        System.out.println("Delete product...");
    }
}
