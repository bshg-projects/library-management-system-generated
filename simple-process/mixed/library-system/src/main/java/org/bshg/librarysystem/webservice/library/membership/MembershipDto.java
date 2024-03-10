package org.bshg.librarysystem.webservice.library.membership;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.webservice.user.client.ClientDto;
import org.bshg.librarysystem.entity.enums.MembershipStatusEnum;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MembershipDto {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private MembershipStatusEnum status;
    private ClientDto client;

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

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto value) {
        this.client = value;
    }
}