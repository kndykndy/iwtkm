package exercises_01_lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Redo allMatches so it works on any List and associated Predicate, not just on Strings. Verify
 * that your examples from #1 still work. But now, you should be able to also do things like this:
 * • List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
 * • List<Integer> bigNums = ElementUtils.allMatches(nums, n -> n>500);
 */
public class Task11 {

    private static class ElementUtils {

        static <T> List<T> allMatches(List<T> elements, Predicate<T> predicate) {
            if (elements == null || elements.isEmpty()) {
                return Collections.emptyList();
            }
            if (predicate == null) {
                return elements;
            }

            return elements.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        }

    }

    public static void main(String[] args) {
        System.out.println(
            "Even length words: " + ElementUtils.allMatches(
                Arrays.asList("lolo", "ayy", "babe", "sweet", "even"),
                s -> (s.length() % 2) == 0));

        System.out.println(
            "Only big nums: " + ElementUtils.allMatches(
                Arrays.asList(1, 10, 100, 1000, 10000),
                n -> n > 500));
    }

}
