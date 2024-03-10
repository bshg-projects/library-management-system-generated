package org.bshg.librarysystem.magazine.sprocess.update;

import org.bshg.librarysystem.magazine.Magazine;

import java.util.List;

public interface UpdateMagazineProcess {
    Magazine run(Magazine item);

    List<Magazine> run(List<Magazine> items);
}
