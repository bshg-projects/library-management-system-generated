package org.bshg.librarysystem.entity.core.event;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="money")
@SequenceGenerator(name = "money_seq", sequenceName = "money_seq", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Money extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "money_seq")
protected Long id;
protected String name;
protected double amount;
public Money() {
super();
}
public Money(Long id, String label) {
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
public double getAmount() {
return amount;
}
public void setAmount(double value) {
this.amount = value;
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