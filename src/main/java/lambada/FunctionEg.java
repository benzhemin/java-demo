package lambada;

import java.util.function.Function;

public class FunctionEg {
    public static void main(String[] args) {
        Function<Integer, Integer> func = (a) -> {
            System.out.println("hee");
            return 1;
        };

        func.apply(2);


    }
}
