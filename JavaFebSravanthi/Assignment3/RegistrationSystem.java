package Assignment3;

import java.util.HashSet;

public class RegistrationSystem {

    // 3. Register method — adds email if not present, rejects if duplicate
    public static boolean register(HashSet<String> set, String email) {
        if (set.contains(email)) {
            System.out.println("Already registered: " + email);
            return false;
        } else {
            set.add(email);
            System.out.println(email + " registered successfully.");
            return true;
        }
    }

    public static void main(String[] args) {

        // 1. Create HashSet and add emails (including duplicate)
        HashSet<String> registeredEmails = new HashSet<>();
        registeredEmails.add("alice@mail.com");
        registeredEmails.add("bob@mail.com");
        registeredEmails.add("carol@mail.com");
        registeredEmails.add("alice@mail.com");   // duplicate — silently ignored
        registeredEmails.add("david@mail.com");

        // 2. Print size — proves duplicate was not added
        System.out.println("Set size: " + registeredEmails.size() + " (not 5 — duplicate ignored)");

        // 3. Call register() with an existing and a new email
        System.out.println();
        register(registeredEmails, "bob@mail.com");   // already exists
        register(registeredEmails, "eve@mail.com");   // new — gets added

        // 4. Check if "carol@mail.com" exists
        System.out.println();
        System.out.println("carol@mail.com exists: " + registeredEmails.contains("carol@mail.com"));

        // 5. Print all emails using for-each
        System.out.println("\nAll registered emails:");
        for (String email : registeredEmails) {
            System.out.println("  " + email);
        }
    }
}