package org.bshg.librarysystem.author;

import jakarta.persistence.*;
import org.bshg.librarysystem.authorbook.AuthorBook;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "author")
@SequenceGenerator(name = "author_seq", sequenceName = "author_seq", allocationSize = 1)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nationality;
    @Lob
    private String biography;
    @OneToMany(mappedBy = "author")
    private List<AuthorBook> authorBook;

    public Author() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate value) {
        this.dateOfBirth = value;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String value) {
        this.nationality = value;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String value) {
        this.biography = value;
    }

    public List<AuthorBook> getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(List<AuthorBook> value) {
        this.authorBook = value;
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