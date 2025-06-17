//question no 2 

// here i have defined Custom Exception
class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}

// This is the Product class
class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    // Constructor with all fields as asked in the question
    public Product(int productId, String productName, double price, int quantity) throws InvalidProductException {
        if (price < 0 || quantity < 0) {
            throw new InvalidProductException("Price and quantity must be non-negative!");
        }
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // I have used default price and quantity
    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
        this.price = 0.0;
        this.quantity = 0;
    }

    
    public void addProduct(int productId, String productName, double price, int quantity) throws InvalidProductException {
        if (price < 0 || quantity < 0) {
            throw new InvalidProductException("Price and quantity must be non-negative!");
        }
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Overloaded addProduct() for name and price.
    public void addProduct(String productName, double price) throws InvalidProductException {
        if (price < 0) {
            throw new InvalidProductException("Price must be non-negative!");
        }
        this.productName = productName;
        this.price = price;
    }

    
    public void addProduct(String productName, double price, int quantity) throws InvalidProductException {
        if (price < 0 || quantity < 0) {
            throw new InvalidProductException("Price and quantity must be non-negative!");
        }
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productId + ", Name: " + productName + 
                           ", Price: " + price + ", Quantity: " + quantity);
    }
}
public class ProductManager {
    public static void main(String[] args) {
        try {
            // Instantiate using constructor with all fields
            Product p1 = new Product(101, "Laptop", 50000.0, 5);
            p1.displayProduct();

            // Instantiate using constructor with partial fields
            Product p2 = new Product(102, "Mouse");
            p2.displayProduct();

            // Using overloaded addProduct() - full details
            p2.addProduct(102, "Mouse", 500.0, 10);
            p2.displayProduct();

            // Using overloaded addProduct() - name and price
            Product p3 = new Product(103, "Keyboard");
            p3.addProduct("Keyboard", 1500.0);
            p3.displayProduct();

            // Using overloaded addProduct() - name, price, quantity
            Product p4 = new Product(104, "Monitor");
            p4.addProduct("Monitor", 12000.0, 3);
            p4.displayProduct();

            // Triggering exception with negative price
            Product p5 = new Product(105, "Tablet", -10000.0, 2);
            p5.displayProduct();

        } catch (InvalidProductException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            Product p6 = new Product(106, "Printer");
            p6.addProduct("Printer", 7000.0, -2);  // This will cause exception
            p6.displayProduct();
        } catch (InvalidProductException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

