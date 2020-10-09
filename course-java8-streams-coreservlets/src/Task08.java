package exercises_01_lambdas;

/**
 * The @FunctionalInterface annotation. Add the annotation to your two interfaces
 * (TwoStringPredicate and TwoElementPredicate). Does adding this annotation change the behavior of
 * your code? What happens if you try to add a second abstract method to TwoStringPredicate?
 */
public class Task08 {

    @FunctionalInterface
    private interface TwoElementPredicate<E1, E2> {

        boolean apply(E1 e1, E2 e2);

    }

    private static class ElementUtils {

        static <T> T betterElement(T e1, T e2, TwoElementPredicate<T, T> predicate) {
            return predicate.apply(e1, e2) ? e1 : e2;
        }

    }

    private static class Car {

        private int price;

        Car(int price) {
            this.price = price;
        }

        int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Car{" + "price=" + price + '}';
        }

    }

    private static class Employee {

        private long salary;

        Employee(int salary) {
            this.salary = salary;
        }

        long getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" + "salary=" + salary + '}';
        }

    }

    public static void main(String[] args) {
        final String string1 = "aaaa", string2 = "bb";

        System.out.println("Better string: " +
            ElementUtils.betterElement(string1, string2, (s1, s2) -> s1.length() > s2.length()));

        System.out.println("Better car: " +
            ElementUtils.betterElement(
                new Car(1), new Car(2), (c1, c2) -> c1.getPrice() > c2.getPrice()));

        System.out.println("Better employee: " +
            ElementUtils.betterElement(
                new Employee(10), new Employee(15), (e1, e2) -> e1.getSalary() > e2.getSalary()));
    }

}
