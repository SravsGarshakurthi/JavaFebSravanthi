package Assignment2.Part1;

public class GreaterThan500 {
    public static void main(String[] args) {
        int num = 6;

        // keep going until we find a number whose square beats 500
        while (num * num <= 500) {
            num++;
        }

        System.out.println("Found it! The number is " + num + " and its square is " + (num * num));
    }
}
