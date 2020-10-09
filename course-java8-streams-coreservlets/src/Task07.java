package exercises_01_lambdas;

/**
 * Making generically-typed interfaces for which lambdas can be used. Use generics to replace
 * your String-specific solutions to problem 3 with generically typed solutions. That is, replace
 * betterString with betterEntry and TwoStringPredicate with TwoElementPredicate. Make sure your
 * previous examples still work when you only change betterString to betterElement. But, now you
 * should also be able to supply two Cars and a Car predicate, two Employees and an Employee
 * predicate, etc. For example:
 * • ElementUtils.betterElement(string1, string2, (s1, s2) -> s1.length() > s2.length())
 * • ElementUtils.betterElement(car1, car2, (c1, c2) -> c1.getPrice() > c2.getPrice())
 * • ElementUtils.betterElement(employee1, employee2, (e1, e2) -> e1.getSalary() > e2.getSalary())
 */
public class Task07 {

    private interface TwoElementPredicate<E1, E2> {

        boolean doBusiness(E1 e1, E2 e2);

    }

    private static class ElementUtils {

        static <T> T betterElement(T e1, T e2, TwoElementPredicate<T, T> predicate) {
            return predicate.doBusiness(e1, e2) ? e1 : e2;
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
