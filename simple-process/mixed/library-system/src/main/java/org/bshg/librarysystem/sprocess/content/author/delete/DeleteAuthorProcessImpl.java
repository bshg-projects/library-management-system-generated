package org.bshg.librarysystem.sprocess.content.author.delete;

import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.delete.DeleteAuthorBookProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteAuthorProcessImpl implements DeleteAuthorProcess {
    private void process(Author item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Author item) {
        process(item);
        deleteAssociated(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        Author item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            Author item = service.findById(id);
            if (item != null) {
                process(item);
                deleteAssociated(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<Author> items) {
        items.forEach(this::process);
        items.forEach(this::deleteAssociated);
        service.delete(items);
    }

    @Transactional(rollbackFor = Exception.class)
    protected void deleteAssociated(Author item) {
        if (item == null || item.getId() == null) return;
        deleteAssociatedList(item);
    }

    private void deleteAssociatedList(Author item) {
        deleteAuthorBookProcess.deleteByAuthor(item);
    }

    @Autowired
    private AuthorService service;
    @Autowired
    @Lazy
    private AuthorBookService authorBookService;
    @Autowired
    @Lazy
    private DeleteAuthorBookProcess deleteAuthorBookProcess;
}