package exercises_01_lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Make a static method called transformedList. It should take a List of Strings and a
 * Function<String,String> and return a new List that contains the results of applying the Function
 * to each element of the original List. E.g.:
 * • List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
 * • List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
 * • List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);
 */
public class Task12 {

    private static class StringUtils {

        static List<String> transformedList(
            List<String> words, Function<String, String> wordFunction) {

            if (words == null || words.isEmpty()) {
                return Collections.emptyList();
            }
            if (wordFunction == null) {
                return words;
            }

            return words.stream()
                .map(wordFunction)
                .collect(Collectors.toList());
        }

    }

    public static void main(String[] args) {
        System.out.println(
            "Exciting words: " + StringUtils.transformedList(
                Arrays.asList("More", "exciting", "words"),
                s -> s + "!"));

        System.out.println(
            "Eye words: " + StringUtils.transformedList(
                Arrays.asList("i of a tiger", "i to i"),
                s -> s.replace("i", "eye")));

        System.out.println(
            "Upper cased words: " + StringUtils.transformedList(
                Arrays.asList("lower", "cased", "words"),
                String::toUpperCase));
    }

}
