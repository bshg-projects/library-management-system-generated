package org.bshg.librarysystem.librarybranch.services;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface LibraryBranchService extends IService<LibraryBranch> {
int deleteByAddressId(Long id);
LibraryBranch findByAddressId(Long id);
}