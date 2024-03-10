package org.bshg.librarysystem.entity.core.event;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.bshg.librarysystem.entity.core.user.Client;

import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction extends Money {
    private LocalDate transactionDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Transaction() {
        super();
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate value) {
        this.transactionDate = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client value) {
        this.client = value;
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