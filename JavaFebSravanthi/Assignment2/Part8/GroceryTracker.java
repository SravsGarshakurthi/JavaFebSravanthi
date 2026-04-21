package Assignment2.Part8;

import java.util.ArrayList;

public class GroceryTracker {

    public static void main(String[] args) {

        // create an ArrayList of strings
        ArrayList<String> groceryList = new ArrayList<String>();

        // add 5 items
        groceryList.add("Idli Rice");
        groceryList.add("Sambar Powder");
        groceryList.add("Coconut Oil");
        groceryList.add("Curry Leaves");
        groceryList.add("Tamarind");

        System.out.println("=== Original Grocery List ===");
        System.out.println(groceryList);

        // remove one item by name
        groceryList.remove("Sambar Powder");
        System.out.println("\nAfter removing 'Sambar Powder': " + groceryList);

        // check if an item is in the list
        if (groceryList.contains("Coconut Oil")) {
            System.out.println("\nCoconut Oil is on the list!");
        } else {
            System.out.println("\nCoconut Oil is NOT on the list.");
        }

        // print total number of items
        System.out.println("\nTotal items in list: " + groceryList.size());

        // print all items using enhanced for loop
        System.out.println("\n=== Final Grocery List ===");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }
}