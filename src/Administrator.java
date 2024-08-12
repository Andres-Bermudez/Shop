import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrator implements Menus {
    protected static String  nameAdministrator;
    private static String emailAdministrator;
    private static String passwordAdministrator;

    protected Administrator(String nameAdministrator ,String emailAdministrator, String passwordAdministrator) {
        Administrator.nameAdministrator = nameAdministrator;
        Administrator.passwordAdministrator = passwordAdministrator;
    }

    protected void verifyAdministrator() {
        String supposedNameAdministrator;
        String supposedPasswordAdministrator;
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter your email: ");
        supposedNameAdministrator = input.nextLine();

        System.out.print("Enter your password: ");
        supposedPasswordAdministrator = input.nextLine();

        if (supposedNameAdministrator.equals(nameAdministrator) &&
                supposedPasswordAdministrator.equals(passwordAdministrator)) {

            administratorMenu();

        } else {
            System.out.println();
            System.out.println("¡Authentication Error!");
        }
    }

    private void administratorMenu() {
        Scanner input = new Scanner(System.in);
        String inputAdministrator = "";

        do {
            System.out.println();
            System.out.println("Welcome Administrator: " + nameAdministrator);
            System.out.println("   1. Show products.");
            System.out.println("   2. Modify product.");
            System.out.println("   3. Add products.");
            System.out.println("   4. Delete product.");
            System.out.println("   0. Return");
            System.out.print("Your Choice: ");

            inputAdministrator = input.nextLine();

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
        Scanner input = new Scanner(System.in);
        String inputAdministrator = "";

        productsList();
        inputAdministrator = input.nextLine();

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
        Scanner input = new Scanner(System.in);

        int productCategory = 0;
        int idProduct = 0;

        do {
            System.out.println();
            System.out.println("Modifying product...");
            System.out.print("Choose the category to which the product to be modified belongs: ");

            try {
                productCategory = input.nextInt();

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
                idProduct = input.nextInt();

            } catch (NumberFormatException e) {
                System.out.println("¡Remember to choose only from the available options!");
            }
        } while(idProduct == 0);

        input.nextLine();

        if (idProduct <= Store.products.size()) {
            String newName = "";
            int newPrice = 0;

            do {
                System.out.print("New name: ");
                newName = input.nextLine();

                System.out.print("New Price: ");

                try {
                    newPrice = input.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("¡The price must be a numerical value!");
                }
                input.nextLine();

            } while (newPrice == 0);

            switch (productCategory) {
                case 1:
                    Store.cellPhones.get(idProduct - 1).setName(newName);
                    Store.cellPhones.get(idProduct - 1).setPrice(newPrice);
                    break;
                case 2:
                    Store.laptops.get(idProduct - 1).setName(newName);
                    Store.laptops.get(idProduct - 1).setPrice(newPrice);
                    break;
                case 3:
                    Store.televisions.get(idProduct - 1).setName(newName);
                    Store.televisions.get(idProduct - 1).setPrice(newPrice);
                    break;
                case 4:
                    Store.fridges.get(idProduct - 1).setName(newName);
                    Store.fridges.get(idProduct - 1).setPrice(newPrice);
                    break;
                case 5:
                    Store.washingMachines.get(idProduct - 1).setName(newName);
                    Store.washingMachines.get(idProduct - 1).setPrice(newPrice);
                    break;
                default:
                    System.out.println("¡Remember to choose only from the available options!");
                    break;
            }
        } else {
            System.out.println("¡Remember to choose only from the available options!");
        }
        System.out.println();
        System.out.println("¡Successfully modified product!");
    }

    private void addProduct() {
        Scanner input = new Scanner(System.in);
        String nameNewProduct = "";
        int priceNewProduct = 0;
        int productCategory = 0;

        do {
            System.out.println();
            System.out.println("Adding a product...");
            System.out.print("Choose the category to which you are going to add a product: ");

            try {
                productCategory = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("¡Remember to choose only from the available options!");
            }

            if (productCategory > Store.products.size() || productCategory <= 0) {
                System.out.println("¡Remember to choose only from the available options!");
            }
        } while (productCategory > Store.products.size() || productCategory <= 0);

        input.nextLine();

        do {
            System.out.println();
            System.out.print("Name product: ");
            nameNewProduct = input.nextLine();

            System.out.print("Product price: ");

            try {
                priceNewProduct = input.nextInt();

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("¡Remember to choose only from the available options!");
            }
            input.nextLine();

        } while (priceNewProduct == 0);

        switch (productCategory) {
            case 1:
                Store.cellPhones.add(new Product(nameNewProduct, priceNewProduct));
                break;
            case 2:
                Store.laptops.add(new Product(nameNewProduct, priceNewProduct));
                break;
            case 3:
                Store.televisions.add(new Product(nameNewProduct, priceNewProduct));
                break;
            case 4:
                Store.fridges.add(new Product(nameNewProduct, priceNewProduct));
                break;
            case 5:
                Store.washingMachines.add(new Product(nameNewProduct, priceNewProduct));
                break;
            default:
                break;
        }
        System.out.println();
        System.out.println("¡Product added correctly!");
    }

    private void deleteProduct() {
        Scanner input = new Scanner(System.in);
        int productCategoryDelete = 0;
        int idProductDelete = 0;

        do {
            System.out.println();
            System.out.println("Delete product...");
            System.out.print("Choose the category to which the product you are going to delete belongs: ");

            try {
                productCategoryDelete = input.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("¡Remember to choose only from the available options!");
            }

            if (productCategoryDelete < 0 || productCategoryDelete > Store.products.size()) {
                System.out.println("¡Remember to choose only from the available options!");
            }
        } while (productCategoryDelete < 0 || productCategoryDelete > Store.products.size());

        switch (productCategoryDelete) {
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
        input.nextLine();

        do {
            System.out.print("Enter the ID of the product you are going to delete: ");
            try {
                idProductDelete = input.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("¡Remember to choose only from the available options!");
            }

            if (idProductDelete < 0 || idProductDelete > Store.products.size()) {
                System.out.println("¡Remember to choose only from the available options!");
            }
        } while (idProductDelete < 0 || idProductDelete > Store.products.size());
        input.nextLine();

        String confirmation = "";

        System.out.println();
        System.out.print("Are you sure to delete this product? yes/no: " );
        confirmation = input.nextLine();

        if (confirmation.equals("yes")) {
            switch (productCategoryDelete) {
                case 1:
                    Store.cellPhones.remove(idProductDelete - 1);
                    break;
                case 2:
                    Store.laptops.remove(idProductDelete - 1);
                    break;
                case 3:
                    Store.televisions.remove(idProductDelete - 1);
                    break;
                case 4:
                    Store.fridges.remove(idProductDelete - 1);
                    break;
                case 5:
                    Store.washingMachines.remove(idProductDelete - 1);
                    break;
                default:
                    break;
            }
            System.out.println();
            System.out.println("¡Product successfully removed!");

        } else {
            System.out.println();
            System.out.println("¡Canceled operation!");
        }
    }
}
