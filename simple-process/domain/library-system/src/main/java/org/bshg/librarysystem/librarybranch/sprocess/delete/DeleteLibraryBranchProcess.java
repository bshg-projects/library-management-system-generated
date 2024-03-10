package org.bshg.librarysystem.librarybranch.sprocess.delete;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.librarybranch.LibraryBranch;

import java.util.List;

public interface DeleteLibraryBranchProcess {
    void run(LibraryBranch item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<LibraryBranch> items);

    void deleteByAddress(Address address);
}