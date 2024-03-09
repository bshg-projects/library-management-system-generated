package org.bshg.librarysystem.sprocess.content.bookgenre.update;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UpdateBookGenreProcessImpl implements UpdateBookGenreProcess {
@Transactional(rollbackFor = Exception.class)
public BookGenre run(BookGenre item) { // Your Logic To Update 'BookGenre'
item = service.edit(item);
return item;
}
public List<BookGenre> run(List<BookGenre> items) {
items.forEach(this::run);
return items;
}
@Autowired private BookGenreService service;
}