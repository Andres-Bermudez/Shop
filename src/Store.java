import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Store {
    private static String nameStore;

    //Lista de productos
    protected static LinkedHashMap<Integer ,LinkedList<Product>> products = new LinkedHashMap<>();

    // Celulares
    protected static LinkedList<Product> cellPhones = new LinkedList<>();

    // Laptops
    protected static LinkedList<Product> laptops = new LinkedList<>();

    // Televisores
    protected static LinkedList<Product> televisions = new LinkedList<>();

    // Neveras
    protected static LinkedList<Product> fridges = new LinkedList<>();

    // Lavadoras
    protected static LinkedList<Product> washingMachines = new LinkedList<>();

    protected Store(String nameStore) {
        Store.nameStore = nameStore;
    }

    protected void addProducts() {
        addCellphones();
        addLaptops();
        addTelevisions();
        addFridges();
        addWashingMachines();

        products.put(1, cellPhones);
        products.put(2, laptops);
        products.put(3, televisions);
        products.put(4, fridges);
        products.put(5, washingMachines);
    }

    private void addCellphones() {
        cellPhones.add(new Product("Iphone", 5000000));
        cellPhones.add(new Product("Samsung", 2000000));
        cellPhones.add(new Product("Xiaomi", 1800000));
        cellPhones.add(new Product("Motorola", 2200000));
        cellPhones.add(new Product("Huawei", 1900000));
    }

    private void addLaptops() {
        laptops.add(new Product("Dell", 3000000));
        laptops.add(new Product("Lenovo", 2900000));
        laptops.add(new Product("Asus", 3200000));
        laptops.add(new Product("HP", 2700000));
        laptops.add(new Product("Mac", 12000000));
    }

    private void addTelevisions() {
        televisions.add(new Product("Sony", 8000000));
        televisions.add(new Product("Samsung", 6000000));
        televisions.add(new Product("LG", 3800000));
        televisions.add(new Product("Kalley", 3200000));
        televisions.add(new Product("TCL", 2900000));
    }

    private void addFridges() {
        fridges.add(new Product("Mabe", 9000000));
        fridges.add(new Product("Haceb", 7000000));
        fridges.add(new Product("Whirpool", 6800000));
        fridges.add(new Product("Electrolux", 5200000));
        fridges.add(new Product("LG", 6900000));
    }

    private void addWashingMachines() {
        washingMachines.add(new Product("Indurama", 3000000));
        washingMachines.add(new Product("Whirpool", 2700000));
        washingMachines.add(new Product("Mabe", 4800000));
        washingMachines.add(new Product("Samsung", 4200000));
        washingMachines.add(new Product("Electrolux", 4900000));
    }

    public static String getNameStore() {
        return nameStore;
    }

    @Override
    public String toString() {
        return "Name Store: " + nameStore + "\n" +
               "Administrator: " + Administrator.nameAdministrator;
    }
}
