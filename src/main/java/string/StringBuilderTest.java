package string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder(256);
        builder.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(builder.toString());

        String[] fields = { "name", "position", "salary" };

        StringBuilder queryPart = new StringBuilder();
        List<String> fieldList = Arrays.asList(fields);
        IntStream.range(0, fieldList.size()).forEach(index -> {
            if (index == 0) queryPart.append("(");
            queryPart.append(fieldList.get(index));
            if (index < fieldList.size() - 1) queryPart.append(", ");
            if (index == fieldList.size() - 1) queryPart.append(")");
        });
        System.out.println(queryPart.toString());
    }
}
