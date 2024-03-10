package org.bshg.librarysystem.money;

import jakarta.persistence.*;

@Entity
@Table(name = "money")
@SequenceGenerator(name = "money_seq", sequenceName = "money_seq", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "money_seq")
    protected Long id;
    protected String name;
    protected double amount;

    public Money() {
    }

    public Money(Long id, String label) {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double value) {
        this.amount = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Money money) {
            return money.getId().equals(this.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }
}