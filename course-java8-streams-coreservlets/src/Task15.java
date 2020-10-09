package exercises_01_lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Using the or method of Predicate [easy if you got problem 2]. Make a method called
 * anyPassPredicate that accepts any number of generically typed Predicates, and returns a single
 * Predicate that tests if the argument passes any of the input Predicates. Then, make a method
 * called firstAnyMatch that takes a Stream and any number of correspondingly-typed Predicates, and
 * returns the first entry that matches any of the Predicates. For example, if words is a
 * List<String>, the following would find the first word that either contains an “o” or has length
 * greater than 5.
 * FunctionUtils.firstAnyMatch(words.stream(),
 * word -> word.contains("o"),
 * word -> word.length() > 5);
 */
public class Task15 {

    private static class FunctionUtils {

        private static Predicate<String> allPassPredicate(List<Predicate<String>> predicates) {
            return s -> {
                for (Predicate<String> predicate : predicates) {
                    if (predicate.test(s)) {
                        return true;
                    }
                }
                return false;
            };
        }

        static Optional<String> firstAnyMatch(
            List<String> words, List<Predicate<String>> predicates) {

            final Predicate<String> unifiedPredicate = allPassPredicate(predicates);

            return words.stream()
                .filter(unifiedPredicate)
                .findFirst();
        }

    }

    public static void main(String[] args) {
        final List<String> words =
            Arrays.asList("l0l0l0", "bug", "Solo", "Han Solo", "mongo");

        System.out.println(
            FunctionUtils.firstAnyMatch(
                words,
                Arrays.asList(
                    word -> word.contains("o"),
                    word -> word.length() > 5
                )));
    }

}
