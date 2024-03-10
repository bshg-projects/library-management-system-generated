package org.bshg.librarysystem.sprocess.library.country.create;

import org.bshg.librarysystem.entity.core.library.Country;

import java.util.List;

public interface CreateCountryProcess {
    Country run(Country item);

    List<Country> run(List<Country> items);
}