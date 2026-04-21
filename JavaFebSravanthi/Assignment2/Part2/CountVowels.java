package Assignment2.Part2;

public class CountVowels {
    static int countVowels(String s) {
        int count = 0;
        s = s.toLowerCase(); // make it case-insensitive

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            // check each character manually
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Vowels in 'Hello World, This is Sravanthi': " + countVowels("Hello World, This is Sravanthi"));
        System.out.println("Vowels in 'Learning Java Programming in Apex': " + countVowels("Learning Java Programming in Apex"));
    }
}
