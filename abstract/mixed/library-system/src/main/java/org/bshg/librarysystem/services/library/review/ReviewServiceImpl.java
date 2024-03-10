package org.bshg.librarysystem.services.library.review;

import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.repository.library.ReviewDao;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
        if (id == null) return 0;
        return dao.deleteByClientId(id);
    }

    @Override
    public List<Review> findByClientId(Long id) {
        return dao.findByClientId(id);
    }

    @Lazy
    @Autowired
    private BookService bookService;
    @Lazy
    @Autowired
    private ClientService clientService;
}