package exercises_01_lambdas;

/**
 * Making your own interfaces for which lambdas can be used. Your eventual goal is to make a
 * method called betterString that takes two Strings and a lambda that says whether the first of
 * the two is “better”. The method should return that better String; i.e., if the function given by
 * the lambda returns true, the betterString method should return the first String, otherwise
 * betterString should  return the second String. Here are two examples of how your code should
 * work when it is finished (the first lambda example returns whichever of string1 and string2
 * is longer, and the second lambda example always returns string1).
 * • String string1 = ...;
 * • String string2 = ...;
 * • String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() >
 * s2.length());
 * • String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
 *
 * Accomplishing all of this requires you to do three things:
 * • Define the TwoStringPredicate interface. It will specify a method that takes 2 strings and
 * returns a boolean. This interface is normal Java 7 code.
 * • Define the static method betterString. That method will take 2 strings and an instance of your
 * interface. It returns string1 if the method in interface returns true, string2 otherwise. This
 * method is normal Java 7 code.
 * • Call betterString. You can now use lambdas for the 3rd argument, as in the examples above.
 */
public class Task06 {

    private interface TwoStringPredicate {

        boolean doBusiness(String s1, String s2);

    }

    private static class StringUtils {

        static String betterString(String s1, String s2, TwoStringPredicate predicate) {
            return predicate.doBusiness(s1, s2) ? s1 : s2;
        }

    }

    public static void main(String[] args) {
        final String string1 = "aaaa", string2 = "bb";

        System.out.println("Longer: " +
            StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length()));

        System.out.println("First: " +
            StringUtils.betterString(string1, string2, (s1, s2) -> true));
        System.out.println("Second: " +
            StringUtils.betterString(string1, string2, (s1, s2) -> false));
    }

}
