package exercises_01_lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Redo transformedList so it works with generic types. Verify that your examples from #3 still
 * work.
 * But now, you should also be able to also do things like this:
 * • List<Integer> wordLengths = ElementUtils.transformedList(words, String::length);
 * Notice above that I am passing in a List of Strings, but getting out a List of Integer. Make sure
 * your generic types support this idea.
 */
public class Task13 {

    private static class ElementUtils {

        static <T, E> List<E> transformedList(
            List<T> words, Function<T, E> wordFunction) {

            if (words == null || words.isEmpty()) {
                return Collections.emptyList();
            }
            if (wordFunction == null) {
                return Collections.emptyList();
            }

            return words.stream()
                .map(wordFunction)
                .collect(Collectors.toList());
        }

    }

    public static void main(String[] args) {
        System.out.println(
            "Word lengths: " + ElementUtils.transformedList(
                Arrays.asList("one", "two", "three", "eight", "eleven"),
                String::length));
    }

}
