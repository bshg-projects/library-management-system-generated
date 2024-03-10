package org.bshg.librarysystem.country.sprocess.create;

import org.bshg.librarysystem.country.Country;

import java.util.List;

public interface CreateCountryProcess {
    Country run(Country item);

    List<Country> run(List<Country> items);
}