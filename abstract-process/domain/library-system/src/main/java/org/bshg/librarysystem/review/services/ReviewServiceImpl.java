package org.bshg.librarysystem.review.services;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.review.ReviewDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl extends ServiceImpl<Review, ReviewDao> implements ReviewService {
    public ReviewServiceImpl(ReviewDao dao) {
        super(dao);
    }

    @Override
    public List<Review> findAllOptimized() {
        return dao.findAllOptimized();
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