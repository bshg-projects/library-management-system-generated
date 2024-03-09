package org.bshg.librarysystem.webservice.event.money;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyDto extends AuditBaseDto {
public MoneyDto() {
super();
}
private String name;
private double amount;
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
}