package org.bshg.librarysystem.sprocess.content.magazine.update;

import org.bshg.librarysystem.entity.core.content.Magazine;
import java.util.List;

public interface UpdateMagazineProcess {
    Magazine run(Magazine item);
    List<Magazine> run(List<Magazine> items);
}
