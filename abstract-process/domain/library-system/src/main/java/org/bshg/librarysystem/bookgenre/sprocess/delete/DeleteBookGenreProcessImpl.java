package org.bshg.librarysystem.bookgenre.sprocess.delete;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

public class DeleteBookGenreProcessImpl extends AbstractDeleteProcessImpl<BookGenre, BookGenreService> implements DeleteBookGenreProcess {
    public DeleteBookGenreProcessImpl(BookGenreService service, BookService bookService, GenreService genreService) {
        super(service);
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @Override
    protected void process(BookGenre item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByBook(Book book) {
        if (book != null && book.getId() != null) {
            service.deleteByBookId(book.getId());
        }
    }

    public void deleteByGenre(Genre genre) {
        if (genre != null && genre.getId() != null) {
            service.deleteByGenreId(genre.getId());
        }
    }

    private BookService bookService;
    private GenreService genreService;
    private DeleteBookProcess deleteBookProcess;

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private DeleteGenreProcess deleteGenreProcess;

    public void setDeleteGenreProcess(DeleteGenreProcess value) {
        this.deleteGenreProcess = value;
    }
}