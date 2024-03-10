package org.bshg.librarysystem.librarybranch.services;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.LibraryBranchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryBranchServiceImpl implements LibraryBranchService {
    @Autowired
    LibraryBranchDao dao;

    @Override
    public LibraryBranch findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<LibraryBranch> findAll() {
        return dao.findAll();
    }

    public List<LibraryBranch> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LibraryBranch create(LibraryBranch item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LibraryBranch edit(LibraryBranch item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(LibraryBranch item) {
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
    public void delete(List<LibraryBranch> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByAddressId(Long id) {
        return dao.deleteByAddressId(id);
    }

    @Override
    public LibraryBranch findByAddressId(Long id) {
        return dao.findByAddressId(id);
    }

    @Autowired
    private AddressService addressService;
}