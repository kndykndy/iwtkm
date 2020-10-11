package exercises_01_lambdas;

import java.util.Arrays;

/**
 * Make an array containing a few Strings. Sort it by reverse length (i.e., longest to shortest)
 */
public class Task02 {

    public static void main(String[] args) {
        final String[] strings = new String[]{"a", "bb", "ccc", "dddd", "eeeee"};

        Arrays.sort(strings, (s1, s2) -> Integer.compare(s2.length(), s1.length()));

        System.out.println(Arrays.asList(strings));
    }

}
