package org.bshg.librarysystem.sprocess.library.librarybranch.facade;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;

import java.util.List;

public interface DeleteLibraryBranchProcess {
    void run(LibraryBranch item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<LibraryBranch> items);

    void deleteByAddress(Address address);
}