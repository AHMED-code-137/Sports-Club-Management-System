package com.mycompany.sportsclubsystem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class SortUtil {

    private SortUtil() {
    }

    /** Sorts a list by its natural order using Java's generic Collections.sort */
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        Collections.sort(list);
    }

    /** Sorts a list by a custom Comparator using Java's generic Collections.sort */
    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        Collections.sort(list, comparator);
    }
}
