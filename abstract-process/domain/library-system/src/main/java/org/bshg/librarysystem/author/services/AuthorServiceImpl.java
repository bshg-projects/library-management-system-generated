package org.bshg.librarysystem.author.services;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.AuthorDao;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AuthorServiceImpl extends ServiceImpl<Author, AuthorDao> implements AuthorService {
public AuthorServiceImpl(AuthorDao dao) {
super(dao);
}
}