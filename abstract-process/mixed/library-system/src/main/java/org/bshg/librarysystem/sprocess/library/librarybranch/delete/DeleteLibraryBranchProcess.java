package org.bshg.librarysystem.sprocess.library.librarybranch.delete;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.library.Address;
public interface DeleteLibraryBranchProcess extends IDeleteProcess<LibraryBranch> {
void deleteByAddress(Address address);
}