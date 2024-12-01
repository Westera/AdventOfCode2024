package aocUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListUtils {

    public static <E> Map<E, Long> getFrequencyMap(List<E> list) {
        return list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }
}
