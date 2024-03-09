package org.bshg.librarysystem.entity.core.event;
import org.bshg.librarysystem.entity.core.user.Client;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="transaction")
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
if (object instanceof Transaction transaction) {
return transaction.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}