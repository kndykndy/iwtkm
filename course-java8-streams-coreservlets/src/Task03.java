package exercises_01_lambdas;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Make an array containing a few Strings. Sort it alphabetically by the first character only.
 *
 * (Hint: charAt(0) returns the numeric code for the first character)
 */
public class Task03 {

    public static void main(String[] args) {
        final String[] strings = new String[]{"clol", "blol", "alol", "dlol"};

        Arrays.sort(strings, (s1, s2) -> Character.compare(s1.charAt(0), s2.charAt(0)));
        // or
        Arrays.sort(strings, Comparator.comparingInt(s -> s.charAt(0)));

        System.out.println(Arrays.asList(strings));
    }

}
