package org.bshg.librarysystem.membership;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.entity.enums.MembershipStatusEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="membership")
@SequenceGenerator(name = "membership_seq", sequenceName = "membership_seq", allocationSize = 1)
public class Membership {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membership_seq")
private Long id;
private String name;
private LocalDate startDate;
private LocalDate endDate;
@Enumerated(EnumType.STRING)
private MembershipStatusEnum status;
@OneToOne()
private Client client;
public Membership() {
super();
}
public Membership(Long id, String label) {
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
public LocalDate getStartDate() {
return startDate;
}
public void setStartDate(LocalDate value) {
this.startDate = value;
}
public LocalDate getEndDate() {
return endDate;
}
public void setEndDate(LocalDate value) {
this.endDate = value;
}
public MembershipStatusEnum getStatus() {
return status;
}
public void setStatus(MembershipStatusEnum value) {
this.status = value;
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