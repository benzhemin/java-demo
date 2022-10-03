package lambada;

@FunctionalInterface
interface IGetValue<T> {
    T getValue();
}

public class LambadaExpress {
    public static void main(String[] args) {
        IGetValue<Float> ref = () -> 3.5f;

        System.out.println("value " + ref.getValue());
    }
}
