package Assignment1;

public class FullNameProgram {
    public static void main(String[] args) {

        String fullName = "  alice marie johnson  ";

        // Step 1: Trim whitespace
        String trimmed = fullName.trim();  // "alice marie johnson"

        // Step 2: Capitalize first letter of each word
        // Split into words, capitalize each, then join
        String[] words = trimmed.split(" ");
        String cleaned = "";
        for (int i = 0; i < words.length; i++) {
            cleaned += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            if (i < words.length - 1) cleaned += " ";
        }
        System.out.println("Cleaned: " + cleaned);

        // Step 3: Extract first, middle, last name using indexOf and substring
        int firstSpace  = cleaned.indexOf(" ");
        int secondSpace = cleaned.indexOf(" ", firstSpace + 1);

        String firstName  = cleaned.substring(0, firstSpace);
        String middleName = cleaned.substring(firstSpace + 1, secondSpace);
        String lastName   = cleaned.substring(secondSpace + 1);
        System.out.println("First: " + firstName + "  Middle: " + middleName + "  Last: " + lastName);

        // Step 4: Count vowels (use toLowerCase so only check a,e,i,o,u)
        String lower = cleaned.toLowerCase();
        int vowelCount = 0;
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }
        System.out.println("Vowel count: " + vowelCount);

        // Step 5: Reverse the string character by character using loop
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed += cleaned.charAt(i);
        }
        System.out.println("Reversed: " + reversed);
    }

    }
