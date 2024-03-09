package org.bshg.librarysystem.payment;
import org.bshg.librarysystem.money.Money;
import org.bshg.librarysystem.client.Client;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="payment")
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
return super.equals(object);
}
@Override
public int hashCode() {
return super.hashCode();
}
}