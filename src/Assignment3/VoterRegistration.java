package Assignment3;

// 1. Custom Exception Class
class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);   // passes message to Exception base class
    }
}

// Main class
public class VoterRegistration {

    // 2. registerVoter method — throws UnderAgeException if age < 18
    public static void registerVoter(String name, int age) throws UnderAgeException {
        if (age >= 18) {
            System.out.println("Registered: " + name);
        } else {
            throw new UnderAgeException(name + " is too young. Age: " + age);
        }
    }

    public static void main(String[] args) {

        // 3. Register three people — one will throw
        String[][] voters = {
                {"Alice", "22"},
                {"Bob",   "16"},
                {"Carol", "18"}
        };

        for (String[] voter : voters) {
            String name = voter[0];
            int    age  = Integer.parseInt(voter[1]);

            // 4. Catch UnderAgeException per person so loop continues
            try {
                registerVoter(name, age);
            } catch (UnderAgeException e) {
                System.out.println("UnderAgeException: " + e.getMessage());
            }
        }

        // 5. Always prints after all registrations attempted
        System.out.println("\nRegistration process completed.");
    }
}