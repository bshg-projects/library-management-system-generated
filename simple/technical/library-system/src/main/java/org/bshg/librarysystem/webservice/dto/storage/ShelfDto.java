package org.bshg.librarysystem.webservice.dto.storage;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShelfDto {
    private Long id;
    private String shelfNumber;
    private List<RackDto> racks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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