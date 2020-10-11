package exercises_01_lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Using the and method of Predicate [hard!]. Now, the point of all of this is that filter takes a
 * single Predicate, not multiple Predicates. The goal of this problem is to make filtering more
 * flexible by making similar filtering code, but that accepts any number of Predicates instead of
 * a single Predicate. To accomplish this, first make a method called allPassPredicate that accepts
 * any number of generically typed Predicates (recall how to use varargs with “...”), and returns a
 * single Predicate that tests if the argument passes all of the input Predicates. Second, make a
 * method called firstAllMatch that takes a Stream and any number of correspondingly-typed
 * Predicates, and returns the first entry that matches all of the Predicates. Your code will
 * simply make the combined Predicate, then call code like that at the top of the page. For
 * example, if words is a List<String>, the following would find the first word that both contains
 * an “o” and has length greater than 5.
 * FunctionUtils.firstAllMatch(words.stream(),
 * word -> word.contains("o"),
 * word -> word.length() > 5);
 * Assuming that you use varargs in your solutions, note that you will receive an odd-sounding
 * warning (not error) about potential heap pollution. It is safe to ignore this error for now, but
 * in the file IO lecture we will briefly explain the warning and show how to suppress it with
 *
 * @SafeVarargs.
 */
public class Task14 {

    private static class FunctionUtils {

        private static Predicate<String> allPassPredicate(List<Predicate<String>> predicates) {
            return s -> {
                for (Predicate<String> predicate : predicates) {
                    if (!predicate.test(s)) {
                        return false;
                    }
                }
                return true;
            };
        }

        static Optional<String> firstAllMatch(
            List<String> words, List<Predicate<String>> predicates) {

            final Predicate<String> unifiedPredicate = allPassPredicate(predicates);

            return words.stream()
                .filter(unifiedPredicate)
                .findFirst();
        }

    }

    public static void main(String[] args) {
        final List<String> words =
            Arrays.asList("lol", "bug", "Solo", "Han Solo", "mongo");

        System.out.println(
            FunctionUtils.firstAllMatch(
                words,
                Arrays.asList(
                    word -> word.contains("o"),
                    word -> word.length() > 5
                )));
    }

}
