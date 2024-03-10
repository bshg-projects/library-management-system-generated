package org.bshg.librarysystem.entity.core.content;

import jakarta.persistence.*;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;

import java.util.List;

@Entity
@Table(name = "genre")
@SequenceGenerator(name = "genre_seq", sequenceName = "genre_seq", allocationSize = 1)
public class Genre extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "genre")
    private List<Magazine> magazines;
    @OneToMany(mappedBy = "genre")
    private List<BookGenre> bookGenre;

    public Genre() {
        super();
    }

    public Genre(Long id, String label) {
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

    public List<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<Magazine> value) {
        this.magazines = value;
    }

    public List<BookGenre> getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(List<BookGenre> value) {
        this.bookGenre = value;
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