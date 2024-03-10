package org.bshg.librarysystem.services.library.librarybranch;

import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.utils.service.IService;

public interface LibraryBranchService extends IService<LibraryBranch> {
    int deleteByAddressId(Long id);

    LibraryBranch findByAddressId(Long id);
}