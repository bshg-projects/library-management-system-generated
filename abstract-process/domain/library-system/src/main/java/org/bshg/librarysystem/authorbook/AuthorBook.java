package org.bshg.librarysystem.authorbook;

import jakarta.persistence.*;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.entity.enums.BookAuthorRoleEnum;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;

/**
 * This Class is for Association between 'Book' and 'Author'
 * It extends AuditEntity to inherit auditing features.
 */
@Entity
@Table(name = "authorbook")
@SequenceGenerator(name = "authorbook_seq", sequenceName = "authorbook_seq", allocationSize = 1)
public class AuthorBook extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorbook_seq")
    private Long id;
    private float contribution;
    @Enumerated(EnumType.STRING)
    private BookAuthorRoleEnum role;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    public AuthorBook() {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public float getContribution() {
        return contribution;
    }

    public void setContribution(float value) {
        this.contribution = value;
    }

    public BookAuthorRoleEnum getRole() {
        return role;
    }

    public void setRole(BookAuthorRoleEnum value) {
        this.role = value;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author value) {
        this.author = value;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book value) {
        this.book = value;
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