package exercises_01_lambdas;

import java.util.Arrays;

/**
 * Redo the problem Task04, but use a static helper method so that your lambda looks like this:
 * Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
 */
public class Task05 {

    public static void main(String[] args) {
        final String[] strings = new String[]{"ewh", "omg", "eel", "fruit", "ewoks"};

        Arrays.sort(strings, (s1, s2) -> myMethod(s1, s2));
        // or
        Arrays.sort(strings, Task05::myMethod);

        System.out.println(Arrays.asList(strings));
    }

    private static int myMethod(String s1, String s2) {
        final boolean s1HasEs = s1.contains("e"), s2HasEs = s2.contains("e");

        return (s1HasEs && s2HasEs) ? 0 : (s1HasEs ? -1 : 1);
    }

}
