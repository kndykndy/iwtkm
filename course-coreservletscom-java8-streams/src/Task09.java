package exercises_01_lambdas;


import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Task09 {

    private static void method1(double value, Function<Double, Double> function) {
        System.out.println("Method 1: " + function.apply(value));
    }

    private static void method2(
        double base, double exp, BiFunction<Double, Double, Double> biFunction) {
        System.out.println("Method 2: " + biFunction.apply(base, exp));
    }

    private static void method3(Supplier<Double> supplier) {
        System.out.println("Method 3: " + supplier.get());
    }

    public static void main(String[] args) {
        method1(0.5, Math::cos);
        method2(2.0, 2.0, Math::pow);
        method3(Math::random);

        System.out.println("For each:");
        Arrays.asList(4, 8, 15, 16, 23, 42).forEach(System.out::println);
    }

}
