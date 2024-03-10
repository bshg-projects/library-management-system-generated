package org.bshg.librarysystem.services.impl.content;

import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.repository.content.AuthorDao;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends ServiceImpl<Author, AuthorDao> implements AuthorService {
    public AuthorServiceImpl(AuthorDao dao) {
        super(dao);
    }
}