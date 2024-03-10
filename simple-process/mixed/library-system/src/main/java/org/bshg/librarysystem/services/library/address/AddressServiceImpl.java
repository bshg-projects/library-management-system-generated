package org.bshg.librarysystem.services.library.address;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.repository.library.AddressDao;
import org.bshg.librarysystem.services.library.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao dao;

    @Override
    public Address findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Address> findAll() {
        return dao.findAll();
    }

    public List<Address> findAllOptimized() {
        return dao.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Address create(Address item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Address edit(Address item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Address item) {
        if (item == null)
            return;
        dao.deleteById(item.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Address> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByCountryId(Long id) {
        return dao.deleteByCountryId(id);
    }

    @Override
    public List<Address> findByCountryId(Long id) {
        return dao.findByCountryId(id);
    }

    @Autowired
    private CountryService countryService;
}