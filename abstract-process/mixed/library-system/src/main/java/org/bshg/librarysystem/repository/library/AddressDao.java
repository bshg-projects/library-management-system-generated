package org.bshg.librarysystem.repository.library;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.utils.repository.Repository;

import java.util.List;

public interface AddressDao extends Repository<Address, Long> {
    int deleteByCountryId(Long id);

    List<Address> findByCountryId(Long id);
}