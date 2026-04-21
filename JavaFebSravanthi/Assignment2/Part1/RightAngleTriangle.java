package Assignment2.Part1;

public class RightAngleTriangle {
    public static void main(String[] args) {
        // outer loop controls the rows, inner loop prints the stars
        for (int row = 1; row <= 5; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println(); // move to next line after each row
        }
    }
}
