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

public class ShoppingCart{
    private static Map<String, Integer> cart = new HashMap<>();
    private static int total = 0;

    /**
     * This method will receive an Item object and and integer value named quantity and will
     * add the item to the cart and add the cost to a total variable
     * @param Item object
     * @param integer quantity
     */
    private static void addItemToCart(Item item, int quantity) {
        cart.put(item.name, quantity);
        total += (cart.get(item.name) * item.price);
        System.out.println("Item added");
    }

    /**
     * This method will receive and Item object and will then show the quantity of the item
     * @param item
     */
    private static void showQuantity(Item item) {
        System.out.println("The quantity of this item is: " + cart.get(item.name));
    }

    /**
     * This method will receive an Item object and a new quantity integer and will update the quantity of the item
     * int the cart and will update the total cost accordingly
     * @param Item object
     * @param int newQuantity
     */
    private static void updateQuantity(Item item, int newQuantity) {
        total -= (cart.get(item.name) * item.price);
        cart.put(item.name, newQuantity);
        total += (cart.get(item.name) * item.price);
        System.out.println("Quantity upadated");
    }

    /**
     * This method will receive an Item as an input and will delete the item from the cart
     * @param Item object
     */
    private static void deleteItem(Item item) {
        total -= (cart.get(item.name) * item.price);
        cart.remove(item.name);
        System.out.println("Item deleted");
    }

    private static void displayTotal() {
        System.out.println("The total bill is: " + total);
    }

    public static void main(String[] args) {
        // List<Item> items = new ArrayList<>();
        Map<String, Item> items = new HashMap<>();
        
        for (int i = 0; i < 10; i++) {
            int id = i;
            char ch = (char) ('0' + i);
            String name = "Item";
            name += ch;
            String description = "This is the description for the item";
            int price = 10 * (i + 1);
            // items.add(new Item(id, name, description, price));
            items.put(name, new Item(id,name,description,price));
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

            int quantity;
            String name;
            switch (choice) {
                case 1:
                    System.out.println("The items available to buy are:-");
                    for (Map.Entry<String,Item> entry : items.entrySet()) {
                        System.out.println(entry.getKey() +": " + entry.getValue().price + "Rs");
                    }
                    scanner.nextLine();
                    System.out.print("Please enter the Name of item: ");
                    System.out.println();
                    name = scanner.nextLine();
                    if (cart.containsKey(name)) {
                        System.out.println("Item is already present in the cart, consider updating the quantity");
                        break;
                    }
                    System.out.print("Please enter the quantity: ");
                    quantity = scanner.nextInt();
                    System.out.println();
                    addItemToCart(items.get(name), quantity);
                    System.out.println();
                    break;

                case 2:
                    if(cart.isEmpty()){
                        System.out.println("No items in your cart, consider adding items to you cart");
                        break;
                    }
                    System.out.println("Items in your cart");
                    for (Map.Entry<String,Integer> entry : cart.entrySet()){
                        System.out.println(entry.getKey() + " Quantity: " + entry.getValue());
                    }
                    System.out.print("Please enter the name of the item: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    if (!cart.containsKey(name)) {
                        System.out.println("No such item in cart.");
                        break;
                    }
                    showQuantity(items.get(name));
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Please enter the name of the item: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    if (!cart.containsKey(name)) {
                        System.out.println("Item not present in the cart");
                        break;
                    }   
                    System.out.print("Please enter the new quantity: ");
                    quantity = scanner.nextInt();
                    System.out.println();
                    updateQuantity(items.get(name), quantity);
                    System.out.println();
                    break;

                case 4:
                    if(cart.isEmpty()){
                        System.out.println("No items present in the cart");
                        break;
                    }
                    System.out.println("Items in your cart");
                    for (Map.Entry<String,Integer> entry : cart.entrySet()){
                        System.out.println(entry.getKey() + "Quantity: " + entry.getValue());
                    }
                    System.out.print("Please enter the name of the item to delete: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    if (!cart.containsKey(name)) {
                        System.out.println("Item not present in the cart");
                        break;
                    }
                    deleteItem(items.get(name));
                    System.out.println();
                    break;

                case 5:
                    displayTotal();
                    System.out.println();
                    break;

                case 6:
                    scanner.close();
                    return;

                default:
                    System.out.println("Please enter a valid number.");
                    System.out.println();
                    break;
            }
        }
    }
}