package org.bshg.librarysystem.services.content.author;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.repository.content.AuthorDao;
import org.bshg.librarysystem.services.content.author.AuthorService;
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