package com.mycompany.sportsclubsystem;

import java.util.Comparator;
import java.util.List;

public final class SortUtil {

    private SortUtil() {
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, (first, second) -> first.compareTo(second));
    }

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
