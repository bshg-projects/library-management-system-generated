package org.bshg.librarysystem.sprocess.library.librarybranch.facade;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteLibraryBranchProcess extends IDeleteProcess<LibraryBranch> {
    void deleteByAddress(Address address);
}