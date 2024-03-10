package org.bshg.librarysystem.sprocess.library.librarybranch.create;

import org.bshg.librarysystem.entity.core.library.LibraryBranch;

import java.util.List;

public interface CreateLibraryBranchProcess {
    LibraryBranch run(LibraryBranch item);

    List<LibraryBranch> run(List<LibraryBranch> items);
}