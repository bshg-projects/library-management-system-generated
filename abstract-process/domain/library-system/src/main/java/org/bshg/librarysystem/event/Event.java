package org.bshg.librarysystem.event;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="event")
@SequenceGenerator(name = "event_seq", sequenceName = "event_seq", allocationSize = 1)
public class Event extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
private Long id;
private String name;
private LocalDate startDate;
private LocalDate endDate;
private String location;
public Event() {
super();
}
public Event(Long id, String label) {
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
public String getLocation() {
return location;
}
public void setLocation(String value) {
this.location = value;
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