package org.bshg.librarysystem.webservice.dto.event;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDto extends AuditBaseDto {
public EventDto() {
super();
}
private String name;
private LocalDate startDate;
private LocalDate endDate;
private String location;
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
}