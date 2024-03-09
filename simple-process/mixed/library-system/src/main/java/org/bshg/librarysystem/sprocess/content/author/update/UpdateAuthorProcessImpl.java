package org.bshg.librarysystem.sprocess.content.author.update;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.sprocess.content.author.update.UpdateAuthorProcess;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.sprocess.content.authorbook.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.delete.DeleteAuthorBookProcess;
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