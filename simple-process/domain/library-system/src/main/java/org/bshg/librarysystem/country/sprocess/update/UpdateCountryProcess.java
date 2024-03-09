package org.bshg.librarysystem.country.sprocess.update;

import org.bshg.librarysystem.country.Country;
import java.util.List;

public interface UpdateCountryProcess {
    Country run(Country item);
    List<Country> run(List<Country> items);
}
