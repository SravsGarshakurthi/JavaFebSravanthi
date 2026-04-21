package Assignment3;

import java.util.ArrayList;

public class ProductManager {

    public static void main(String[] args) throws InterruptedException {

        // 1. Create ArrayList with 7 products
        ArrayList<String> products = new ArrayList<>();
        products.add("Laptop");
        products.add("Phone");
        products.add("Tablet");
        products.add("Monitor");
        products.add("Keyboard");
        products.add("Mouse");
        products.add("Headphones");

        // 2. Sort alphabetically using lambda Comparator
        products.sort((a, b) -> a.compareTo(b));
        System.out.println("Alphabetical: " + products);

        // 3. Sort by name length (shortest first) using lambda
        products.sort((a, b) -> a.length() - b.length());
        System.out.println("By length:    " + products);

        // 4. Lambda with Runnable — runs on a new thread
        Runnable printTask = () -> System.out.println("Processing product list...");
        Thread thread = new Thread(printTask);
        thread.start();
        thread.join();   // wait for thread to finish before continuing

        // 5. removeIf() with lambda — removes products shorter than 6 characters
        products.removeIf(p -> p.length() < 6);
        System.out.println("After removeIf (length < 6): " + products);
    }
}