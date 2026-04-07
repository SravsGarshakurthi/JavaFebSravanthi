package Assignment3;

import java.util.HashMap;
import java.util.Map;

public class MarkSheet {
    public static void main(String[] args) {

        // 1. Create HashMap and add 5 student entries
        HashMap<String, Integer> markSheet = new HashMap<>();
        markSheet.put("Alice", 88);
        markSheet.put("Bob", 74);
        markSheet.put("Carol", 95);
        markSheet.put("David", 60);
        markSheet.put("Eva", 82);

        // 2. Get Bob's marks using get(), Frank's using getOrDefault()
        System.out.println("Bob's marks: " + markSheet.get("Bob"));
        System.out.println("Frank's marks: " + markSheet.getOrDefault("Frank", 0));

        // 3. Update David's marks to 75
        markSheet.put("David", 75);

        // 4. Check if "Carol" key exists
        System.out.println("Carol present: " + markSheet.containsKey("Carol"));

        // 5. Loop through all entries using entrySet()
        System.out.println("\n=== Mark Sheet ===");
        for (Map.Entry<String, Integer> entry : markSheet.entrySet()) {
            System.out.println("Name: " + entry.getKey() + "  Marks: " + entry.getValue());
        }

        // 6. Print total number of entries
        System.out.println("\nTotal entries: " + markSheet.size());
    }
}