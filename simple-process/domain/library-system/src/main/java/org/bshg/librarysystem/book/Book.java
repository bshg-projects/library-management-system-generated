package org.bshg.librarysystem.book;

import jakarta.persistence.*;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.rack.Rack;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
@SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    private Long id;
    private String title;
    private LocalDate publicationDate;
    private String isbn;
    private int pageCount;
    @Lob
    private String description;
    @OneToMany(mappedBy = "book")
    private List<AuthorBook> authorBook;
    @OneToMany(mappedBy = "book")
    private List<BookGenre> bookGenre;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;
    @ManyToOne(fetch = FetchType.LAZY)
    private Rack rack;

    public Book() {
        super();
    }

    public Book(Long id, String label) {
// constructor to get optimized fields
        this.id = id;
        this.title = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate value) {
        this.publicationDate = value;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String value) {
        this.isbn = value;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int value) {
        this.pageCount = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public List<AuthorBook> getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(List<AuthorBook> value) {
        this.authorBook = value;
    }

    public List<BookGenre> getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(List<BookGenre> value) {
        this.bookGenre = value;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee value) {
        this.employee = value;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher value) {
        this.publisher = value;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack value) {
        this.rack = value;
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