package Assignment2.Part2;

public class CountOccurrences {
    static int countOccurrences(String text, String word) {
        int count = 0;
        int pos = 0;

        // scan through the text looking for the word each time
        while ((pos = text.indexOf(word, pos)) != -1) {
            count++;
            pos += word.length(); // move past the word we just found
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("'the' appears: " + countOccurrences("the cat sat on the mat", "the") + " times"); // 2
        System.out.println("'hello' appears: " + countOccurrences("hello hello hello", "hello") + " times");  // 3
    }
}
