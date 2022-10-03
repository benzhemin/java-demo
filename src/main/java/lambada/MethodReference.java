package lambada;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://www.baeldung.com/java-method-references
@Getter
@Setter
class Bicycle {
    private String brand;
    private Integer size;

    public Bicycle(String brand, Integer size) {
        this.brand = brand;
        this.size = size;
    }

    @Override
    public String toString() {
        return "brand: " + this.brand + " size:" + this.size;
    }
}

class BicycleComparator implements Comparator<Bicycle> {
    @Override
    public int compare(Bicycle o1, Bicycle o2) {
        return o1.getSize().compareTo(o2.getSize());
    }
}

public class MethodReference {
    public static void main(String[] args) {
        BicycleComparator comparator = new BicycleComparator();
        List<Bicycle> bicycleList = List.of(
                new Bicycle("D", 6),
                new Bicycle("B", 3),
                new Bicycle("C", 8),
                new Bicycle("A", 4)
        );

        List<Bicycle> sortedList = bicycleList.stream().sorted(comparator).toList();

        sortedList.forEach(System.out::println);

        System.out.println("-----------------------");

        // to array
        Bicycle[] bicycleArray = sortedList.stream().toArray(Bicycle[]::new);
        Arrays.stream(bicycleArray).forEach(System.out::println);
    }

}
