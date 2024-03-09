package org.bshg.librarysystem.category.webservice;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto extends AuditBaseDto {
public CategoryDto() {
super();
}
private String name;
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
}