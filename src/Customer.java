import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer implements Menus {
    private int customerElectionCategory = 0;
    private int customerElectionIDproduct = 0;

    protected void buyProducts() {
        Scanner sc = new Scanner(System.in);

        do {
            if (ShopingCart.listProductsBuy.isEmpty()) {
                productsList();
            } else {
                menuWithFullCart();
            }

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
                continueShopping();
                break;
            case 2:
                laptopList();
                continueShopping();
                break;
            case 3:
                televisionsList();
                continueShopping();
                break;
            case 4:
                fridgesList();
                continueShopping();
                break;
            case 5:
                whashingMachinesList();
                continueShopping();
                break;
            default:
                System.out.println("¡Remember to choose only from the available options!");
                break;
        }
    }

    private void continueShopping() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("    0. Return");
            System.out.print("Choose the product you are going to add to the cart: ");
            try {
                customerElectionIDproduct = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("¡Remember to choose only from the available options!");
            }

            if (customerElectionIDproduct < 0) {
                System.out.println("¡Remember to choose only from the available options!");
            } else if (customerElectionIDproduct == 0) {
                buyProducts();
            }
        } while (customerElectionIDproduct < 0);

        ShopingCart shopingCart = new ShopingCart();

        switch (customerElectionCategory) {
            case 1:
                if (customerElectionIDproduct <= Store.cellPhones.size()) {
                    shopingCart.addCart(Store.cellPhones.get(customerElectionIDproduct - 1));
                }
                break;
            case 2:
                if (customerElectionIDproduct <= Store.laptops.size()) {
                    shopingCart.addCart(Store.laptops.get(customerElectionIDproduct - 1));
                }
                break;
            case 3:
                if (customerElectionIDproduct <= Store.televisions.size()) {
                    shopingCart.addCart(Store.televisions.get(customerElectionIDproduct - 1));
                }
                break;
            case 4:
                if (customerElectionIDproduct <= Store.fridges.size()) {
                    shopingCart.addCart(Store.fridges.get(customerElectionIDproduct - 1));
                }
                break;
            case 5:
                if (customerElectionIDproduct <= Store.washingMachines.size()) {
                    shopingCart.addCart(Store.washingMachines.get(customerElectionIDproduct - 1));
                }
                break;
            default:
                System.out.println("¡Remember to choose only from the available options!");
                break;
        }
        buyProducts();
    }

    private void menuWithFullCart() {
        Scanner sc = new Scanner(System.in);
        int inputUser = 0;
        do {
            System.out.println();
            System.out.println(">>> Welcome <<<");
            System.out.println("    1. Product List");
            System.out.println("    2. My cart");
            System.out.print("Your choice: ");

            try {
                inputUser = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("¡Remember to choose only from the available options!");
            }

            switch (inputUser) {
                case 1:
                    productsList();
                    break;
                case 2:
                    ShopingCart.showShoppingCart();
                    confirmPurchase();
                    break;
                default:
                    System.out.println("¡Remember to choose only from the available options!");
                    break;
            }
        } while (inputUser < 0 || inputUser > 2);
    }

    private void confirmPurchase() {
        Scanner sc = new Scanner(System.in);
        int inputUser = 0;


        System.out.println("  1. Go to pay");
        System.out.println("  2. Remove product from cart");
        System.out.print("Your choice: ");

        try {
            inputUser = sc.nextInt();

        } catch(InputMismatchException e) {
            System.out.println();
            System.out.println("¡Remember to choose only from the available options!");
        }

        switch (inputUser) {
            case 1:
                break;
            case 2:
                confirmDeleteProduct();
                break;
            default:
                break;
        }
    }

    private void confirmDeleteProduct() {
        String productEliminate = "";
        Scanner sc = new Scanner(System.in);

        ShopingCart.showShoppingCart();
        System.out.print("Enter the name of the product you are going to delete: ");
        productEliminate = sc.nextLine();

        for (Product i : ShopingCart.listProductsBuy) {
            if (i.getName().equals(productEliminate)) {
                ShopingCart.removeCart(i);
                buyProducts();

            } else {
                System.out.println();
                System.out.println("¡The product you entered is not in your cart!");
                menuWithFullCart();
            }
        }
    }
}