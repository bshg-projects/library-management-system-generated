package org.bshg.librarysystem.entity.core.library;

import jakarta.persistence.*;

@Entity
@Table(name = "librarybranch")
@SequenceGenerator(name = "librarybranch_seq", sequenceName = "librarybranch_seq", allocationSize = 1)
public class LibraryBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "librarybranch_seq")
    private Long id;
    private String name;
    @OneToOne()
    private Address address;

    public LibraryBranch() {
        super();
    }

    public LibraryBranch(Long id, String label) {
// constructor to get optimized fields
        this.id = id;
        this.name = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
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