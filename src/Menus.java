public interface Menus {

    default void welcomeMenu() {
        System.out.println();
        System.out.println(":: Welcome to " + Store.getNameStore() + " ::");
        System.out.println("Enter as:");
        System.out.println("   1. Client");
        System.out.println("   2. Administrador");
        System.out.println("   0. Exit");
        System.out.print("Your Choice: ");
    }

    default void productsList() {
        System.out.println();
        System.out.println(">>>>> List of products <<<<<");
        System.out.println("1. Cellphones");
        System.out.println("2. Laptops");
        System.out.println("3. Televisions");
        System.out.println("4. Fridges");
        System.out.println("5. Washing Machines");
        System.out.println("0. Return.");
        System.out.print("Your Choice: ");
    }

    default void cellphonesList() {
        int counter = 1;

        System.out.println();
        System.out.println(">>> Cellphones <<<");
        for(Product p : Store.cellPhones) {
            System.out.println(counter + ". " + p.toString());
            counter++;
        }
    }

    default void laptopList() {
        int counter = 1;

        System.out.println();
        System.out.println(">>> Laptops <<<");
        for(Product p : Store.laptops) {
            System.out.println(counter + ". " + p.toString());
            counter++;
        }
    }

    default void televisionsList() {
        int counter = 1;

        System.out.println();
        System.out.println(">>> Televisions <<<");
        for(Product p : Store.televisions) {
            System.out.println(counter + ". " + p.toString());
            counter++;
        }
    }

    default void fridgesList() {
        int counter = 1;

        System.out.println();
        System.out.println(">>> Fridges <<<");
        for(Product p : Store.fridges) {
            System.out.println(counter + ". " + p.toString());
            counter++;
        }
    }

    default void whashingMachinesList() {
        int counter = 1;

        System.out.println();
        System.out.println(">>> Whashing Machines <<<");
        for(Product p : Store.washingMachines) {
            System.out.println(counter + ". " + p.toString());
            counter++;
        }
    }
}
