package org.bshg.librarysystem.utils.service;

import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.utils.util.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class ServiceHelper {
    private ServiceHelper(){}

    public static <T extends AuditEntity> List<List<T>> getToBeSavedAndToBeDeleted(List<T> oldList, List<T> newList) {
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

    private static <T extends AuditEntity, L extends AuditEntity> void populateSaveOrUpdate(List<L> oldList, List<L> newList, List<L> resultUpdateOrSave) {
        newList.forEach(myNew -> {
            L item = ListUtil.findFirstEquals(oldList, myNew);
            if (item == null) {
                resultUpdateOrSave.add(myNew);
            }
        });
    }

    private static <T extends AuditEntity, L extends AuditEntity> void separateToDeleteAndToUpdate(List<L> oldList, List<L> newList, List<L> resultUpdateOrSave, List<L> resultDelete) {
        oldList.forEach(myOld -> {
            L item = ListUtil.findFirstEquals(newList, myOld);
            if (item != null) {
                resultUpdateOrSave.add(item);
            } else {
                resultDelete.add(myOld);
            }
        });
    }

    public static <T extends AuditEntity, L extends AuditEntity, S extends IService<L>>
    void createList( T entity, Function<T, List<L>> getter, BiConsumer<L, T> setter, S service) {
        List<L> list = getter.apply(entity);
        if (list != null) {
            list.forEach(el -> {
                setter.accept(el, entity);
                service.create(el);
            });
        }
    }

    public static < T extends AuditEntity, L extends AuditEntity, S extends IService<L>>
    void updateList(T item, LongFunction<List<L>> getOldList, Function<T, List<L>> getNewList, BiFunction<List<L>, List<L>, List<List<L>>> listsFilter, Consumer<L> applyBeforeUpdating,S service) {
        List<List<L>> result = listsFilter.apply(getOldList.apply(item.getId()), getNewList.apply(item));
        service.delete(result.get(1));
        ListUtil.emptyIfNull(result.get(0)).forEach(applyBeforeUpdating);
        service.update(result.get(0));
    }

    public static < T extends AuditEntity, L extends AuditEntity, S extends IService<L>>
    void updateList(T item, LongFunction<List<L>> getOldList, Function<T, List<L>> getNewList, BiConsumer<L, T> setItem, S service) {
        updateList(item, getOldList, getNewList, ServiceHelper::getToBeSavedAndToBeDeleted, it -> setItem.accept(it, item), service);
    }
}
