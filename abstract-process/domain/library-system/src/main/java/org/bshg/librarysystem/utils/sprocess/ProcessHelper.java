package org.bshg.librarysystem.utils.sprocess;

import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.utils.sprocess.facade.ICreateProcess;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.utils.sprocess.facade.IUpdateProcess;
import org.bshg.librarysystem.utils.util.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class ProcessHelper {
    private ProcessHelper() {
    }

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

    public static <T extends AuditEntity, L extends AuditEntity, CP extends ICreateProcess<L>> void createList(
            T entity,
            Function<T, List<L>> getter,
            BiConsumer<L, T> function,
            CP createProcess) {
        List<L> list = getter.apply(entity);
        if (list != null) {
            list.forEach(el -> {
                function.accept(el, entity);
                createProcess.run(el);
            });
        }
    }

    public static <
            T extends AuditEntity,
            L extends AuditEntity,
            UP extends IUpdateProcess<L>,
            DP extends IDeleteProcess<L>
            >
    void updateList(
            T item,
            LongFunction<List<L>> getOldList,
            Function<T, List<L>> getNewList,
            BiFunction<List<L>, List<L>, List<List<L>>> listsFilter,
            Consumer<L> applyBeforeUpdating,
            UP updateProcess,
            DP deleteProcess
    ) {
        List<List<L>> result = listsFilter.apply(getOldList.apply(item.getId()), getNewList.apply(item));
        deleteProcess.run(result.get(1));
        ListUtil.emptyIfNull(result.get(0)).forEach(applyBeforeUpdating);
        updateProcess.run(result.get(0));
    }

    public static <
            T extends AuditEntity,
            L extends AuditEntity,
            UP extends IUpdateProcess<L>,
            DP extends IDeleteProcess<L>
            >
    void updateList(
            T item,
            LongFunction<List<L>> getOldList,
            Function<T, List<L>> getNewList,
            BiConsumer<L, T> setItem,
            UP updateProcess,
            DP deleteProcess
    ) {
        updateList(
                item, getOldList, getNewList,
                ProcessHelper::getToBeSavedAndToBeDeleted,
                it -> setItem.accept(it, item),
                updateProcess, deleteProcess
        );
    }
}
