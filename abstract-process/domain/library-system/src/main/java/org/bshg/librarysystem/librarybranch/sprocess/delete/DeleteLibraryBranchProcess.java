package org.bshg.librarysystem.librarybranch.sprocess.delete;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.address.Address;
public interface DeleteLibraryBranchProcess extends IDeleteProcess<LibraryBranch> {
void deleteByAddress(Address address);
}