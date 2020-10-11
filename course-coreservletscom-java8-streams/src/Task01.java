package exercises_01_lambdas;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Make an array containing a few Strings. Sort it by length (i.e., shortest to longest)
 */
public class Task01 {

    public static void main(String[] args) {
        final String[] strings = new String[]{"really really long", "short", "omg medium"};

        Arrays.sort(strings, (s1, s2) -> {
            if (s1 == null || s2 == null) {
                throw new NullPointerException();
            }

            return Integer.compare(s1.length(), s2.length());
        });
        // As sx.length will give NPE as well, use this form:
        Arrays.sort(strings, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        // or
        Arrays.sort(strings, Comparator.comparingInt(String::length));

        System.out.println(Arrays.asList(strings));
    }

}
