package lambada;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

// https://medium.com/swlh/understanding-java-8s-consumer-supplier-predicate-and-function-c1889b9423d
public class Functional {

    public void consumerTest() {

        Consumer<String> printConsumer = (value) -> System.out.println("value: " + value);

        Consumer<String> composite = printConsumer.andThen((value) -> System.out.println("world -> consumer"));

        composite.accept("Hello");
    }

    public static void upperCaseCities() {
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        List<String> upperCaseCityList = cities.stream().map(String::toUpperCase).toList();

        upperCaseCityList.forEach(System.out::println);
    }

    public static void supplierTest() {
        Supplier<Double> supplier = () -> Math.random();
        DoubleSupplier anotherSupplier = Math::random;

        int hashCode = anotherSupplier.hashCode();
        System.out.println("hash code: " + hashCode);

        double doubleValue = anotherSupplier.getAsDouble();
        System.out.println("double value" + doubleValue);
    }

    public static void functionTest() {
        Function<String, String> process = value -> {
            System.out.println(value + " processing");
            return value;
        };

        Function<String, String> before = value -> {
            System.out.println(value + " before");
            return value;
        };

        Function<String, String> after = value -> {
            System.out.println(value + " after");
            return value;
        };

        Function<String, String> compose = process.compose(before).andThen(after);
        compose.apply("hello");

    }

    public static void predictTest() {
        Predicate<Integer> evenPredict = value -> value % 2 == 0;
        Predicate<Integer> greaterThenFive = value -> value > 5;

        Predicate<Integer> combinedPredict = evenPredict.and(greaterThenFive);

        List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> filteredList = numberList.stream()
                .filter(combinedPredict)
                .toList();

        filteredList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Functional funcObj = new Functional();
        funcObj.consumerTest();

        upperCaseCities();
        supplierTest();
        supplierTest();
        predictTest();
        functionTest();


    }

}
