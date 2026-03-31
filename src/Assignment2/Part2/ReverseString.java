package Assignment2.Part2;

public class ReverseString {
    static String reverseString(String s) {
        String reversed = "";

        // start from the end and build the reversed string one char at a time
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println("Reverse of 'Hello': " + reverseString("Hello"));   // olleH
        System.out.println("Reverse of 'How are you': " + reverseString("How are you"));     // avaJ
    }
}
