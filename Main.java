import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class InventoryItem extends Item {
    private int quantity;

    public InventoryItem(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative.");
        }
    }

    @Override
    public String toString() {
        return "Item: " + getName() + ", Quantity: " + quantity;
    }
}

class InventoryManager {
    private ArrayList<InventoryItem> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    public void addItem(String name, int quantity) {
        InventoryItem newItem = new InventoryItem(name, quantity);
        inventory.add(newItem);
    }

    public void removeItem(String name) {
        InventoryItem itemToRemove = null;
        for (InventoryItem item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            inventory.remove(itemToRemove);
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public void searchItem(String name) {
        for (InventoryItem item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.println("Item found: " + item);
                return;
            }
        }
        System.out.println("Item not found in inventory.");
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (InventoryItem item : inventory) {
            System.out.println(item);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager inventoryManager = new InventoryManager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Search Item");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    inventoryManager.addItem(itemName, quantity);
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.next();
                    inventoryManager.removeItem(itemToRemove);
                    break;
                case 3:
                    System.out.print("Enter item name to search: ");
                    String itemToSearch = scanner.next();
                    inventoryManager.searchItem(itemToSearch);
                    break;
                case 4:
                    inventoryManager.displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
