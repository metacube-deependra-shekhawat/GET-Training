import java.util.*;

class Item {
    public int id;
    public int price;
    public String name;
    public String description;

    public Item(int id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}

public class Assignment1{
    private static Map<Integer, Integer> cart = new HashMap<>();
    private static int total = 0;

    /**
     * This method will receive an Item object and and integer value named quantity and will
     * add the item to the cart and add the cost to a total variable
     * @param Item object
     * @param integer quantity
     */
    public static void addItemToCart(Item item, int quantity) {
        if (cart.containsKey(item.id)) {
            System.out.println("Item is already present in the cart, consider updating the quantity");
            return;
        }
        cart.put(item.id, quantity);
        total += (cart.get(item.id) * item.price);
    }

    /**
     * This method will receive and Item object and will then show the quantity of the item
     * @param item
     */
    public static void showQuantity(Item item) {
        if (!cart.containsKey(item.id)) {
            System.out.println("No such item in cart.");
            return;
        }
        System.out.println("The quantity of this item is: " + cart.get(item.id));
    }

    /**
     * This method will receive an Item object and a new quantity integer and will update the quantity of the item
     * int the cart and will update the total cost accordingly
     * @param Item object
     * @param int newQuantity
     */
    public static void updateQuantity(Item item, int newQuantity) {
        total -= (cart.get(item.id) * item.price);
        cart.put(item.id, newQuantity);
        total += (cart.get(item.id) * item.price);
    }

    /**
     * This method will receive an Item as an input and will delete the item from the cart
     * @param Item object
     */
    public static void deleteItem(Item item) {
        if (!cart.containsKey(item.id)) {
            System.out.println("Item not present in the cart");
            return;
        }
        total -= (cart.get(item.id) * item.price);
        cart.remove(item.id);
    }

    public static void displayTotal() {
        System.out.println("The total sum is: " + total);
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int id = i;
            char ch = (char) ('0' + i);
            String name = "Item_";
            name += ch;
            String description = "This is the description for the item";
            int price = 10 * (i + 1);
            items.add(new Item(id, name, description, price));
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to add Item to cart.");
            System.out.println("Enter 2 to show quantity of item.");
            System.out.println("Enter 3 to update quantity of item.");
            System.out.println("Enter 4 to delete item.");
            System.out.println("Enter 5 to display total.");
            System.out.println("Enter 6 to exit.");
            System.out.print("Please enter your choice here: ");
            int choice = scanner.nextInt();

            int id, quantity;
            switch (choice) {
                case 1:
                    System.out.print("Please enter the id of item: ");
                    id = scanner.nextInt();
                    System.out.println();
                    System.out.print("Please enter the quantity: ");
                    quantity = scanner.nextInt();
                    System.out.println();
                    addItemToCart(items.get(id), quantity);
                    break;

                case 2:
                    System.out.print("Please enter the id of the item: ");
                    id = scanner.nextInt();
                    System.out.println();
                    showQuantity(items.get(id));
                    break;

                case 3:
                    System.out.print("Please enter the id of the item: ");
                    id = scanner.nextInt();
                    System.out.println();
                    System.out.print("Please enter the new quantity: ");
                    quantity = scanner.nextInt();
                    System.out.println();
                    updateQuantity(items.get(id), quantity);
                    break;

                case 4:
                    System.out.print("Please enter the id of the item: ");
                    id = scanner.nextInt();
                    System.out.println();
                    deleteItem(items.get(id));
                    break;

                case 5:
                    displayTotal();
                    break;

                case 6:
                    scanner.close();
                    return;

                default:
                    System.out.println("Please enter a valid number.");
                    break;
            }
        }
    }
}