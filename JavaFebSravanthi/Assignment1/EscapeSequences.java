package Assignment1;
public class EscapeSequences {
    public static void main(String[] args) {
        // \n (newline)
        System.out.println("Hello!\nWelcome to the store.");

        // \t (tab)
        System.out.println("Name:\tJohn");

        // \\ (backslash)
        System.out.println("Path: C:\\Users\\Documents");

        // \" (double quote)
        System.out.println("She said, \"Have a great day!\"");

        // \' (single quote)
        System.out.println("It\'s a wonderful morning.");

        // Receipt using only println + escape characters
        System.out.println("\n---- RECEIPT ----");
        System.out.println("Item\t\t\tPrice");
        System.out.println("Coffee\t\t\tRs. 50");
        System.out.println("Sandwich\t\tRs. 120");
    }
}