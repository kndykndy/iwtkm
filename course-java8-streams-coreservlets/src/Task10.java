package exercises_01_lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Make a static method called allMatches. It should take a List of Strings and a
 * Predicate<String>, and return a new List of all the values that passed the test. Test it with
 * several examples. E.g.:
 * • List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
 * • List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
 * • List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);
 */
public class Task10 {

    private static class StringUtils {

        static List<String> allMatches(List<String> words, Predicate<String> stringPredicate) {
            if (words == null || words.isEmpty()) {
                return Collections.emptyList();
            }
            if (stringPredicate == null) {
                return words;
            }

            return words.stream()
                .filter(stringPredicate)
                .collect(Collectors.toList());
        }

    }

    public static void main(String[] args) {
        System.out.println(
            "Short words: " + StringUtils.allMatches(
                Arrays.asList("longlong", "long", "lil", "sml"),
                s -> s.length() < 4));

        System.out.println(
            "Words with b: " + StringUtils.allMatches(
                Arrays.asList("withb", "no", "brown", "babe", "sweetie"),
                s -> s.contains("b")));

        System.out.println(
            "Even length words: " + StringUtils.allMatches(
                Arrays.asList("lolo", "ayy", "babe", "sweet", "even"),
                s -> (s.length() % 2) == 0));
    }

}
