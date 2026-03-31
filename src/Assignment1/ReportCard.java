package Assignment1;

public class ReportCard {
    public static void main(String[] args) {

        // ── Hardcoded marks (change these to test different sets) ──
        int maths   = 88;
        int science = 76;
        int english = 92;
        int history = 68;
        int java    = 95;

        // ── Print subject-wise marks ──
        System.out.println("Maths: " + maths + "  Science: " + science +
                "  English: " + english + "  History: " + history +
                "  Java: " + java);

        // ── Total and Percentage ──
        int total = maths + science + english + history + java;
        double percentage = total / 5.0;
        System.out.printf("Total: %d  Percentage: %.1f%%%n", total, percentage);

        // ── Grade using if-else ──
        String grade;
        if (percentage >= 90)      grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B";
        else if (percentage >= 60) grade = "C";
        else if (percentage >= 50) grade = "D";
        else                       grade = "F";

        // ── Pass/Fail using TERNARY (all subjects must be >= 40) ──
        boolean allPassed = (maths >= 40 && science >= 40 && english >= 40
                && history >= 40 && java >= 40);
        String status = allPassed ? "PASS" : "FAIL";

        System.out.println("Grade: " + grade + "  Status: " + status);

        // ── Highest and Lowest scoring subject ──
        int max = maths;
        String highSubject = "Maths";
        int min = maths;
        String lowSubject = "Maths";

        if (science > max)  { max = science; highSubject = "Science"; }
        if (english > max)  { max = english; highSubject = "English"; }
        if (history > max)  { max = history; highSubject = "History"; }
        if (java > max)     { max = java;    highSubject = "Java";    }

        if (science < min)  { min = science; lowSubject = "Science"; }
        if (english < min)  { min = english; lowSubject = "English"; }
        if (history < min)  { min = history; lowSubject = "History"; }
        if (java < min)     { min = java;    lowSubject = "Java";    }
        System.out.println("Highest: " + highSubject + " (" + max + ")" +
                "  Lowest: " + lowSubject  + " (" + min + ")");

        // ── Scholarship using TERNARY (percentage >= 85 AND passed all) ──
        String scholarship = (percentage >= 85 && allPassed)
                ? "Eligible for Merit Scholarship"
                : "Not Eligible (below 85%)";
        System.out.println("Scholarship: " + scholarship);
    }
    }


