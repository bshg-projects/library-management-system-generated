package org.bshg.librarysystem.utils.service;

import org.bshg.librarysystem.utils.entity.BaseEntity;
import org.bshg.librarysystem.utils.util.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class ServiceHelper {
    private ServiceHelper(){}

    public static <T> List<List<T>> getToBeSavedAndToBeDeleted(List<T> oldList, List<T> newList) {
        boolean oldEmpty = ListUtil.isEmpty(oldList);
        boolean newEmpty = ListUtil.isEmpty(newList);

        List<List<T>> result = new ArrayList<>();
        List<T> resultDelete = new ArrayList<>();
        List<T> resultUpdateOrSave = new ArrayList<>();

        if (!newEmpty && oldEmpty) {
            resultUpdateOrSave.addAll(newList);
        } else if (newEmpty && !oldEmpty) {
            resultDelete.addAll(oldList);
        } else if (!newEmpty) {
            populateSaveOrUpdate(oldList, newList, resultUpdateOrSave);
            separateToDeleteAndToUpdate(oldList, newList, resultUpdateOrSave, resultDelete);
        }

        result.add(resultUpdateOrSave);
        result.add(resultDelete);
        return result;
    }

    private static <T, L> void populateSaveOrUpdate(List<L> oldList, List<L> newList, List<L> resultUpdateOrSave) {
        newList.forEach(myNew -> {
            L item = ListUtil.findFirstEquals(oldList, myNew);
            if (item == null) {
                resultUpdateOrSave.add(myNew);
            }
        });
    }

    private static <T, L> void separateToDeleteAndToUpdate(List<L> oldList, List<L> newList, List<L> resultUpdateOrSave, List<L> resultDelete) {
        oldList.forEach(myOld -> {
            L item = ListUtil.findFirstEquals(newList, myOld);
            if (item != null) {
                resultUpdateOrSave.add(item);
            } else {
                resultDelete.add(myOld);
            }
        });
    }

    public static <T, L>
    void createList( T entity, Function<T, List<L>> getter, BiConsumer<L, T> setter, Function<L,L> creator) {
        List<L> list = getter.apply(entity);
        if (list != null) {
            list.forEach(el -> {
                setter.accept(el, entity);
                creator.apply(el);
            });
        }
    }

    public static < T, L>
    void updateList(
        T item,
        List<L> oldList,
        List<L> newList,
        BiConsumer<L, T> setter,
        Consumer<List<L>> updater,
        Consumer<List<L>> deleter
    ) {
        List<List<L>> result = getToBeSavedAndToBeDeleted(oldList, newList);
        deleter.accept(result.get(1));
        ListUtil.emptyIfNull(result.get(0)).forEach(it -> setter.accept(it, item));
        updater.accept(result.get(0));
    }
}
