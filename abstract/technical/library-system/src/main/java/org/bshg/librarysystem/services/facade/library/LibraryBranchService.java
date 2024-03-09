package org.bshg.librarysystem.services.facade.library;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface LibraryBranchService extends IService<LibraryBranch> {
int deleteByAddressId(Long id);
LibraryBranch findByAddressId(Long id);
}