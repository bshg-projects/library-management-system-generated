package org.bshg.librarysystem.sprocess.content.magazine.facade;

import org.bshg.librarysystem.entity.core.content.Magazine;

import java.util.List;

public interface CreateMagazineProcess {
    Magazine run(Magazine item);

    List<Magazine> run(List<Magazine> items);
}