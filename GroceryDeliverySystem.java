import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
  
// Define classes and data structures
import java.util.*;

class Customer {
    String name;
    String address;
    String phoneNumber;
}

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

// Define order class
class Order {
    Customer customer;
    List<Product> products;
    double totalPrice;
    Date deliveryDate;

    public Order() {
        products = new ArrayList<>();
    }
}

// Define DeliverySchedule class
class DeliverySchedule {
    Date startDate;
    Date endDate;

    // Constructor for DeliverySchedule class
    public DeliverySchedule(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

public class GroceryDeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueShopping = true;
        List<Product> availableProducts = new ArrayList<>();
        List<DeliverySchedule> availableDeliverySchedules = new ArrayList<>();
        Order currentOrder = new Order();

        // Populate available products
        availableProducts.add(new Product("Apples", 2.99, 100));
        availableProducts.add(new Product("Bananas", 1.99, 150));
        availableProducts.add(new Product("Milk", 3.49, 50));
        availableProducts.add(new Product("Bread", 2.49, 75));
        availableProducts.add(new Product("Eggs", 4.99, 30));
      
        // Populate available delivery schedules
        availableDeliverySchedules.add(new DeliverySchedule(new Date(), new Date()));
        availableDeliverySchedules.add(new DeliverySchedule(new Date(), new Date()));

        // Welcome message
        System.out.println("Welcome to the Grocery Delivery System!");

        // Main loop
        while (continueShopping) {
            System.out.println("1. Browse Products");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Perform actions based on user choice 
            switch (choice) {
                case 1:
                    browseProducts(availableProducts);
                    break;
                case 2:
                    viewCart(currentOrder);
                    break;
                case 3:
                    checkout(currentOrder);
                    break;
                case 4:
                    continueShopping = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Grocery Delivery System!");
    }

    public static void browseProducts(List<Product> availableProducts) {
        System.out.println("List of available products:");
        for (Product product : availableProducts) {
            System.out.println("Name: " + product.name);
            System.out.println("Price: $" + product.price);
            System.out.println("Quantity available: " + product.quantity);
            System.out.println("-----------------------");
        }
    }

    public static void viewCart(Order order) {
        if (order.products.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart:");
            for (Product product : order.products) {
                System.out.println("Name: " + product.name);
                System.out.println("Price: $" + product.price);
                System.out.println("Quantity: " + product.quantity);
                System.out.println("-----------------------");
            }
            System.out.println("Total Price: $" + order.totalPrice);
        }
    }

    // Method block for checkout 
    public static void checkout(Order order) {
        Scanner scanner = new Scanner(System.in);
        order.customer = new Customer();

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        order.customer.name = customerName;

        System.out.print("Enter your address: ");
        String customerAddress = scanner.nextLine();
        order.customer.address = customerAddress;

        System.out.print("Enter your phone number: ");
        String customerPhoneNumber = scanner.nextLine();
        order.customer.phoneNumber = customerPhoneNumber;

        System.out.print("Select delivery date (YYYY-MM-DD): ");
        String deliveryDateStr = scanner.nextLine();
        // Parse deliveryDateStr to Date format and assign to order.deliveryDate

        System.out.println("Your order has been confirmed! Delivery scheduled for " + deliveryDateStr);
    }
}
