package lambada;

import java.util.Optional;
import java.util.function.Function;

class OptionalUnit {

    public void optionalTest() {
        Optional<String> stringOpt = Optional.of("Hello");

        Function<String, Integer> mapper = String::length;

        Optional<Integer> res = stringOpt.map(mapper);

        res.ifPresent(System.out::println);
    }
}

public class OptionalTest {


    public static void main(String[] args) {
        OptionalUnit ou = new OptionalUnit();

        ou.optionalTest();
    }
}
