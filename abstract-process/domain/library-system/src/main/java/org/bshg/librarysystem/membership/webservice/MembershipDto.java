package org.bshg.librarysystem.membership.webservice;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.client.webservice.ClientDto;
import org.bshg.librarysystem.entity.enums.MembershipStatusEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MembershipDto extends AuditBaseDto {
public MembershipDto() {
super();
}
private String name;
private LocalDate startDate;
private LocalDate endDate;
private MembershipStatusEnum status;
private ClientDto client;
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
public ClientDto getClient() {
return client;
}
public void setClient(ClientDto value) {
this.client = value;
}
}