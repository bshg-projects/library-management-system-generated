package org.bshg.librarysystem.entity.core.content;

import jakarta.persistence.*;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;

import java.util.List;

@Entity
@Table(name = "publisher")
@SequenceGenerator(name = "publisher_seq", sequenceName = "publisher_seq", allocationSize = 1)
public class Publisher extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
    @OneToMany(mappedBy = "publisher")
    private List<Magazine> magazines;
    @OneToOne()
    private Address address;

    public Publisher() {
        super();
    }

    public Publisher(Long id, String label) {
// constructor to get optimized fields
        this.id = id;
        this.name = label;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> value) {
        this.books = value;
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<Magazine> value) {
        this.magazines = value;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address value) {
        this.address = value;
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