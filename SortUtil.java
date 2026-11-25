import java.util.Comparator;
import java.util.List;

/** Utility class: generic sorting methods (selection sort). */
public final class SortUtil {

    // Private constructor: all methods are static, so no objects are needed.
    private SortUtil() {
    }

    /** Sorts a list by its natural order (compareTo). */
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, (first, second) -> first.compareTo(second));
    }

    /** Sorts a list by any order given as a Comparator. */
    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}
