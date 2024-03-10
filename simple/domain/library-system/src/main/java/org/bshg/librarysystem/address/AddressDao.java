package org.bshg.librarysystem.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressDao extends JpaRepository<Address, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByCountryId(Long id);

    List<Address> findByCountryId(Long id);
}