package org.bshg.librarysystem.shelf;

import jakarta.persistence.*;
import org.bshg.librarysystem.rack.Rack;

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
        if (object instanceof Shelf shelf) {
            return shelf.getId().equals(this.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }
}