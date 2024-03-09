package org.bshg.librarysystem.sprocess.library.country.update;

import org.bshg.librarysystem.entity.core.library.Country;
import java.util.List;

public interface UpdateCountryProcess {
    Country run(Country item);
    List<Country> run(List<Country> items);
}
