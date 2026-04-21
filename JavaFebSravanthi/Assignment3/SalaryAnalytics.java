package Assignment3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SalaryAnalytics {

    public static void main(String[] args) {

        // 1. Salary data
        List<Integer> salaries = Arrays.asList(
                25000, 42000, 15000, 68000,
                31000, 72000, 19000, 55000
        );

        // 2a. Ascending order using sorted()
        List<Integer> ascending = salaries.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ascending:  " + ascending);

        // 2b. Descending order using sorted(Comparator.reverseOrder())
        List<Integer> descending = salaries.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Descending: " + descending);

        // 3. Total salary using reduce()
        int total = salaries.stream()
                .reduce(0, Integer::sum);
        System.out.println("\nTotal salary:       " + total);

        // 4. Count salaries above 40000 using filter() + count()
        long countAbove40k = salaries.stream()
                .filter(s -> s > 40000)
                .count();
        System.out.println("Count above 40000:  " + countAbove40k);

        // 5. First salary greater than 60000 using filter() + findFirst()
        int firstAbove60k = salaries.stream()
                .filter(s -> s > 60000)
                .findFirst()
                .orElse(-1);
        System.out.println("First salary > 60000: " + firstAbove60k);

        // 6. Average salary using mapToInt() + average()
        double average = salaries.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println("Average salary:     " + average);
    }
}