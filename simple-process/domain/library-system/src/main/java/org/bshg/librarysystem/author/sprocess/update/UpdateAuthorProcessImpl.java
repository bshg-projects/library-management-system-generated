package org.bshg.librarysystem.author.sprocess.update;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.author.sprocess.update.UpdateAuthorProcess;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.sprocess.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.authorbook.sprocess.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UpdateAuthorProcessImpl implements UpdateAuthorProcess {
@Transactional(rollbackFor = Exception.class)
public Author run(Author item) { // Your Logic To Update 'Author'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
public List<Author> run(List<Author> items) {
items.forEach(this::run);
return items;
}
public void updateAssociatedList(Author item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
authorBookService.findByAuthorId(item.getId()),
item.getAuthorBook(),
AuthorBook::setAuthor,
updateAuthorBookProcess::run,
deleteAuthorBookProcess::run
);
}
@Autowired private AuthorService service;
@Autowired AuthorBookService authorBookService;
@Autowired @Lazy private UpdateAuthorBookProcess updateAuthorBookProcess;
@Autowired @Lazy private DeleteAuthorBookProcess deleteAuthorBookProcess;
}