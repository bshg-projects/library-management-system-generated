package org.bshg.librarysystem.librarybranch.services;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.LibraryBranchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryBranchServiceImpl implements LibraryBranchService {
    //--------------- FIND -------------------------------------
    public LibraryBranch findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<LibraryBranch> findAll() {
        return dao.findAll();
    }

    public List<LibraryBranch> findAllOptimized() {
        return dao.findAllOptimized();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public LibraryBranch create(LibraryBranch item) {
        if (item == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<LibraryBranch> create(List<LibraryBranch> items) {
        List<LibraryBranch> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public LibraryBranch update(LibraryBranch item) {
        if (item == null || item.getId() == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<LibraryBranch> update(List<LibraryBranch> items) {
        List<LibraryBranch> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        LibraryBranch item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(LibraryBranch item) {
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<LibraryBranch> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByAddressId(Long id) {
        return dao.deleteByAddressId(id);
    }

    @Override
    public LibraryBranch findByAddressId(Long id) {
        return dao.findByAddressId(id);
    }

    //----------------------------------------------------------
//----------------------------------------------------------
    @Autowired
    private LibraryBranchDao dao;
    @Lazy
    @Autowired
    private AddressService addressService;
}