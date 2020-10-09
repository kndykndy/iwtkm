package exercises_01_lambdas;

import java.util.Arrays;

/**
 * Make an array containing a few Strings. Sort it by Strings that contain “e” first, everything
 * else second. For now, put the code directly in the lambda.
 *
 * (Hint: remember that the body of a lambda is allowed to have curly braces and a return statement.
 * See the first two lambda examples in the notes.)
 */
public class Task04 {

    public static void main(String[] args) {
        final String[] strings = new String[]{"ewh", "omg", "eel", "fruit", "ewoks"};

        Arrays.sort(strings, (s1, s2) -> {
            final boolean s1HasEs = s1.contains("e"), s2HasEs = s2.contains("e");

            return (s1HasEs && s2HasEs) ? 0 : (s1HasEs ? -1 : 1);
        });

        System.out.println(Arrays.asList(strings));
    }

}
