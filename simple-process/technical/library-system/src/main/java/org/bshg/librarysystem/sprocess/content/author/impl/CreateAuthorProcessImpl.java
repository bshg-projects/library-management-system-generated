package org.bshg.librarysystem.sprocess.content.author.impl;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.sprocess.content.author.facade.CreateAuthorProcess;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.CreateAuthorBookProcess;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateAuthorProcessImpl implements CreateAuthorProcess {
@Transactional(rollbackFor = Exception.class)
public Author run(Author item) {
// Your Creation Logic For 'Author'
item = service.create(item);
createAssociatedList(item);
return item;
}
public List<Author> run(List<Author> items) {
items.forEach(this::run);
return items;
}
public void createAssociatedList(Author item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Author::getAuthorBook, AuthorBook::setAuthor, createAuthorBookProcess::run);
}
@Autowired private AuthorService service;
@Autowired private AuthorBookService authorBookService;
@Autowired @Lazy private CreateAuthorBookProcess createAuthorBookProcess;
}