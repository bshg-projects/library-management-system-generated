package org.bshg.librarysystem.magazine.sprocess.create;

import org.bshg.librarysystem.magazine.Magazine;

import java.util.List;

public interface CreateMagazineProcess {
    Magazine run(Magazine item);

    List<Magazine> run(List<Magazine> items);
}