package org.bshg.librarysystem.entity.core.event;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.bshg.librarysystem.entity.core.user.Client;

import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment extends Money {
    private LocalDate paymentDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Payment() {
        super();
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate value) {
        this.paymentDate = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client value) {
        this.client = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Payment payment) {
            return payment.getId().equals(this.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }
}