package org.bshg.librarysystem.country.services;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.CountryDao;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    //--------------- FIND -------------------------------------
    public Country findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Country> findAll() {
        return dao.findAll();
    }

    public List<Country> findAllOptimized() {
        return dao.findAllOptimized();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Country create(Country item) {
        if (item == null) return null;
        Country saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Country> create(List<Country> items) {
        List<Country> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Country update(Country item) {
        if (item == null || item.getId() == null) return null;
        Country saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Country> update(List<Country> items) {
        List<Country> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Country item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Country item) {
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Country> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            Country item = findById(id);
            if (item != null) {
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
    public void createAssociatedList(Country item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Country::getAddresses, Address::setCountry, addressService::create);
    }

    public void updateAssociatedList(Country item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(
                item, addressService.findByCountryId(item.getId()),
                item.getAddresses(), Address::setCountry,
                addressService::update,
                addressService::delete
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(Country item) {
        deleteAssociatedList(item);
    }

    public void deleteAssociatedList(Country item) {
        addressService.deleteByCountryId(item.getId());
    }

    //----------------------------------------------------------
    @Autowired
    private CountryDao dao;
    @Lazy
    @Autowired
    private AddressService addressService;
}