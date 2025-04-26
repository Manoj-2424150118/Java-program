import java.util.Scanner;
import java.util.Vector;

class ShoppingList {
    Vector<String> items;

    public ShoppingList() {
        items = new Vector<>();
    }

    // Add initial items
    public void addInitialItems(Scanner sc) {
        System.out.println("Enter 5 shopping items:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            items.add(sc.nextLine());
        }
    }

    // Delete item by name
    public void deleteItem(String item) {
        if (items.remove(item)) {
            System.out.println("Item '" + item + "' removed successfully.");
        } else {
            System.out.println("Item '" + item + "' not found.");
        }
    }

    // Add item at specific position
    public void addItemAt(int index, String item) {
        if (index >= 0 && index <= items.size()) {
            items.add(index, item);
            System.out.println("Item '" + item + "' added at position " + index + ".");
        } else {
            System.out.println("Invalid position. Item not added.");
        }
    }

    // Add item at end
    public void addItemAtEnd(String item) {
        items.add(item);
        System.out.println("Item '" + item + "' added at the end.");
    }

    // Print current list
    public void printList() {
        System.out.println("Current Shopping List:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }
}

public class ShoppingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingList list = new ShoppingList();

        // Step 1: Add 5 items
        list.addInitialItems(sc);
        list.printList();

        // Step 2: Delete an item
        System.out.print("\nEnter item to delete: ");
        String deleteItem = sc.nextLine();
        list.deleteItem(deleteItem);
        list.printList();

        // Step 3: Add item at a specified index
        System.out.print("\nEnter item to add: ");
        String newItem = sc.nextLine();
        System.out.print("Enter position to insert (0-based index): ");
        int position = sc.nextInt();
        sc.nextLine(); // consume newline
        list.addItemAt(position, newItem);
        list.printList();

        // Step 4: Add item at end
        System.out.print("\nEnter item to add at the end: ");
        String endItem = sc.nextLine();
        list.addItemAtEnd(endItem);
        list.printList();

        sc.close();
    }
}
