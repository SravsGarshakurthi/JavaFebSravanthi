package Assignment2.Part8;

public class QuizScoreAnalyzer {

    public static void main(String[] args) {

        // 8 quiz scores
        int[] scores = {85, 92, 78, 90, 88, 76, 95, 89};

        int highest = scores[0]; // assume first is highest
        int lowest  = scores[0]; // assume first is lowest
        int sum     = 0;

        for (int i = 0; i < scores.length; i++) {
            // check for highest
            if (scores[i] > highest) {
                highest = scores[i];
            }
            // check for lowest
            if (scores[i] < lowest) {
                lowest = scores[i];
            }
            // add to sum for average
            sum += scores[i];
        }

        double average = (double) sum / scores.length;

        System.out.println("=== Quiz Score Report ===");
        System.out.println("Highest Score : " + highest);
        System.out.println("Lowest Score  : " + lowest);
        System.out.println("Average Score : " + average);
    }
}