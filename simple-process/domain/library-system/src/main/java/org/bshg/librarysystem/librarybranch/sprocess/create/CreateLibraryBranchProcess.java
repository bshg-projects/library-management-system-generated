package org.bshg.librarysystem.librarybranch.sprocess.create;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import java.util.List;
public interface CreateLibraryBranchProcess {
LibraryBranch run(LibraryBranch item);
List<LibraryBranch> run(List<LibraryBranch> items);
}