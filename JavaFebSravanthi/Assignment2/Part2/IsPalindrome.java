package Assignment2.Part2;

public class IsPalindrome {
    static boolean isPalindrome(String s) {
        // remove spaces and lowercase everything before checking
        String cleaned = s.toLowerCase().replace(" ", "");

        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed += cleaned.charAt(i);
        }

        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {
        System.out.println("'racecar' is palindrome: " + isPalindrome("racecar"));                       // true
        System.out.println("'Hello' is palindrome: " + isPalindrome("Hello"));                           // false
    }
}
