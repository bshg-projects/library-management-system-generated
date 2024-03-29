package org.bshg.librarysystem.services.library.review;

import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.repository.library.ReviewDao;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewDao dao;

    @Override
    public Review findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Review> findAll() {
        return dao.findAll();
    }

    public List<Review> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Review create(Review item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Review edit(Review item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Review item) {
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
    public void delete(List<Review> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByBookId(Long id) {
        return dao.deleteByBookId(id);
    }

    @Override
    public Review findByBookId(Long id) {
        return dao.findByBookId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByClientId(Long id) {
        return dao.deleteByClientId(id);
    }

    @Override
    public List<Review> findByClientId(Long id) {
        return dao.findByClientId(id);
    }

    @Autowired
    private BookService bookService;
    @Autowired
    private ClientService clientService;
}