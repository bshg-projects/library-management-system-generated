package org.bshg.librarysystem.shelf.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.rack.webservice.RackDto;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShelfDto extends AuditBaseDto {
    public ShelfDto() {
        super();
    }

    private String shelfNumber;
    private List<RackDto> racks;

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String value) {
        this.shelfNumber = value;
    }

    public List<RackDto> getRacks() {
        return racks;
    }

    public void setRacks(List<RackDto> value) {
        this.racks = value;
    }
}