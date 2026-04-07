package Assignment3;

import java.util.ArrayList;

public class ToDoList {
    public static void main(String[] args) {

        // 1. Create ArrayList and add 5 tasks
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Buy groceries");
        tasks.add("Read a book");
        tasks.add("Exercise");
        tasks.add("Call mom");
        tasks.add("Pay bills");

        // 2. Print all tasks with numbering
        System.out.println("=== Initial Task List ===");
        int count = 1;
        for (String task : tasks) {
            System.out.println(count + ". " + task);
            count++;
        }

        // 3. Remove "Exercise" by value, then remove index 0 ("Buy groceries")
        tasks.remove("Exercise");
        tasks.remove(0);

        // 4. Check if "Pay bills" is present
        System.out.println("\nPay bills present: " + tasks.contains("Pay bills"));

        // 5. Add "Study Java" at index 1
        tasks.add(1, "Study Java");

        // 6. Print final list and size
        System.out.println("\n=== Final Task List ===");
        int finalCount = 1;
        for (String task : tasks) {
            System.out.println(finalCount + ". " + task);
            finalCount++;
        }
        System.out.println("List size: " + tasks.size());
    }
}