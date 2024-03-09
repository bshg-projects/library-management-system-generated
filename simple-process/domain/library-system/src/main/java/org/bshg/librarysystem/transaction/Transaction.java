package org.bshg.librarysystem.transaction;
import org.bshg.librarysystem.money.Money;
import org.bshg.librarysystem.client.Client;
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
return super.equals(object);
}
@Override
public int hashCode() {
return super.hashCode();
}
}