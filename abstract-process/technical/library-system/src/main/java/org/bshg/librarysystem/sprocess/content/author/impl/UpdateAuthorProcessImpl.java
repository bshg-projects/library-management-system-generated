package org.bshg.librarysystem.sprocess.content.author.impl;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.sprocess.content.author.facade.UpdateAuthorProcess;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.DeleteAuthorBookProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateAuthorProcessImpl extends AbstractUpdateProcessImpl<Author, AuthorService> implements UpdateAuthorProcess {
public UpdateAuthorProcessImpl(AuthorService service, AuthorBookService authorBookService) {
super(service);
this.authorBookService = authorBookService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Author run(Author item) {
// Your Update Logic For 'Author'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
@Override
public void updateAssociatedList(Author item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
authorBookService::findByAuthorId,
Author::getAuthorBook,
AuthorBook::setAuthor,
updateAuthorBookProcess,
deleteAuthorBookProcess
);
}
private AuthorBookService authorBookService;
private UpdateAuthorBookProcess updateAuthorBookProcess;
private DeleteAuthorBookProcess deleteAuthorBookProcess;
public void setUpdateAuthorBookProcess(UpdateAuthorBookProcess value) {
this.updateAuthorBookProcess = value;
}
public void setDeleteAuthorBookProcess(DeleteAuthorBookProcess value) {
this.deleteAuthorBookProcess = value;
}
}