package org.bshg.librarysystem.entity.core.content;

import jakarta.persistence.*;

/**
 * This Class is for Association between 'Book' and 'Genre'
 */
@Entity
@Table(name = "bookgenre")
@SequenceGenerator(name = "bookgenre_seq", sequenceName = "bookgenre_seq", allocationSize = 1)
public class BookGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookgenre_seq")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;

    public BookGenre() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book value) {
        this.book = value;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre value) {
        this.genre = value;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}