package Assignment3;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DataProcessor {

    public static void main(String[] args) {

        // ── 1. PREDICATE ──────────────────────────────────────────────
        Predicate<Integer> isEven          = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThan50 = n -> n > 50;

        // Test individually with 48 and 72
        System.out.println("48 is even:      " + isEven.test(48));           // true
        System.out.println("48 > 50:         " + isGreaterThan50.test(48));  // false
        System.out.println("72 is even:      " + isEven.test(72));           // true
        System.out.println("72 > 50:         " + isGreaterThan50.test(72));  // true

        // Combine with .and() — both must be true
        Predicate<Integer> isEvenAndOver50 = isEven.and(isGreaterThan50);
        System.out.println("72 is even AND > 50: " + isEvenAndOver50.test(72));  // true

        // ── 2. FUNCTION ───────────────────────────────────────────────
        System.out.println();
        Function<String, String> addGreeting = name -> "Hello, " + name + "!";

        System.out.println(addGreeting.apply("Alice"));   // Hello, Alice!
        System.out.println(addGreeting.apply("Bob"));     // Hello, Bob!

        // ── 3. CONSUMER ───────────────────────────────────────────────
        System.out.println();
        Consumer<String> printUpperCase = word -> System.out.println(word.toUpperCase());

        List<String> words = List.of("java", "streams", "lambda");
        words.forEach(printUpperCase);   // JAVA  STREAMS  LAMBDA

        // ── 4. SUPPLIER ───────────────────────────────────────────────
        System.out.println();
        Supplier<Double> randomScore = () -> Math.random() * 100;

        System.out.printf("Score 1: %.2f%n", randomScore.get());
        System.out.printf("Score 2: %.2f%n", randomScore.get());
        System.out.printf("Score 3: %.2f%n", randomScore.get());
    }
}