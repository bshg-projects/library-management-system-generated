package org.bshg.librarysystem.entity.core.storage;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "shelf")
@SequenceGenerator(name = "shelf_seq", sequenceName = "shelf_seq", allocationSize = 1)
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shelf_seq")
    private Long id;
    private String shelfNumber;
    @OneToMany(mappedBy = "shelf")
    private List<Rack> racks;

    public Shelf() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String value) {
        this.shelfNumber = value;
    }

    public List<Rack> getRacks() {
        return racks;
    }

    public void setRacks(List<Rack> value) {
        this.racks = value;
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