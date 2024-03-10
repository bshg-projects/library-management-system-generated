package org.bshg.librarysystem.utils.sprocess.facade;

import java.util.List;

public interface IDeleteProcess<T> {
    void run(T item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<T> items);
}
