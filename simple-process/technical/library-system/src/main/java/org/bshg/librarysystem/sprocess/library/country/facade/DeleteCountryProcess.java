package org.bshg.librarysystem.sprocess.library.country.facade;

import org.bshg.librarysystem.entity.core.library.Country;

import java.util.List;

public interface DeleteCountryProcess {
    void run(Country item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Country> items);
}