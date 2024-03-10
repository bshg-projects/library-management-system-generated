package org.bshg.librarysystem.sprocess.library.librarybranch.facade;

import org.bshg.librarysystem.entity.core.library.LibraryBranch;

import java.util.List;

public interface UpdateLibraryBranchProcess {
    LibraryBranch run(LibraryBranch item);

    List<LibraryBranch> run(List<LibraryBranch> items);
}
