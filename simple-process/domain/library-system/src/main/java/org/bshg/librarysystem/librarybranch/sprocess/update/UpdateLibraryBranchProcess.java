package org.bshg.librarysystem.librarybranch.sprocess.update;

import org.bshg.librarysystem.librarybranch.LibraryBranch;
import java.util.List;

public interface UpdateLibraryBranchProcess {
    LibraryBranch run(LibraryBranch item);
    List<LibraryBranch> run(List<LibraryBranch> items);
}
