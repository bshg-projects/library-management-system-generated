package org.bshg.librarysystem.utils.service;

import org.bshg.librarysystem.utils.entity.BaseEntity;

import java.util.List;

public interface IService<T extends BaseEntity> {
    T findById(Long id);

    List<T> findAllOptimized();

    List<T> findAll();

    T create(T item);

    List<T> create(List<T> item);

    T update(T item);

    List<T> update(List<T> item);

    void deleteById(Long id);

    void delete(T item);

    void delete(List<T> items);

    void deleteByIdIn(List<Long> ids);
}
