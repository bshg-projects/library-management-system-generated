package org.bshg.librarysystem.services.facade.library;

import org.bshg.librarysystem.entity.core.library.LibraryBranch;

import java.util.List;

public interface LibraryBranchService {
    LibraryBranch findById(Long id);

    List<LibraryBranch> findAllOptimized();

    List<LibraryBranch> findAll();

    LibraryBranch create(LibraryBranch item);

    List<LibraryBranch> create(List<LibraryBranch> item);

    LibraryBranch update(LibraryBranch item);

    List<LibraryBranch> update(List<LibraryBranch> item);

    void deleteById(Long id);

    void delete(LibraryBranch item);

    void delete(List<LibraryBranch> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByAddressId(Long id);

    LibraryBranch findByAddressId(Long id);
}