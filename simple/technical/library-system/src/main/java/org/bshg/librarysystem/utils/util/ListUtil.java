package org.bshg.librarysystem.utils.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListUtil {

    private ListUtil() {
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    public static <T> List<T> emptyIfNull(List<T> list) {
        return isEmpty(list) ? new ArrayList<>() : list;
    }

    public static <T> List<T> removed(List<T> coll1, List<T> coll2) {
        List<T> intersection = new ArrayList<>();
        if (coll1 != null)
            for (T object : coll1) {
                if (coll2 != null && !coll2.contains(object))
                    intersection.add(object);
            }

        return intersection;
    }

    public static <T> List<T> added(List<T> coll1, List<T> coll2) {
        List<T> intersection = new ArrayList<>();
        if (coll2 != null)
            for (T object : coll2) {
                if (coll1 != null && !coll1.contains(object))
                    intersection.add(object);
            }

        return intersection;
    }

    public static <T> T filterAndFindFirst(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).findFirst().orElse(null);
    }

    public static <T> T findFirstEquals(List<T> list, T item) {
        return filterAndFindFirst(list, item::equals);
    }


    public static <O, G> List<G> map(List<O> origin, Function<O, G> mapper) {
        if (origin == null || origin.isEmpty()) {
            return new ArrayList<>();
        }
        return origin.stream().map(mapper).toList();
    }

}
