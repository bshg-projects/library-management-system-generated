package org.bshg.librarysystem.webservice.library.reservation;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.entity.enums.ReservationStatusEnum;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.webservice.content.book.BookDto;
import org.bshg.librarysystem.webservice.user.client.ClientDto;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDto extends AuditBaseDto {
    public ReservationDto() {
        super();
    }

    private String name;
    private BookDto book;
    private LocalDate reservationDate;
    private ReservationStatusEnum status;
    private ClientDto client;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto value) {
        this.book = value;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate value) {
        this.reservationDate = value;
    }

    public ReservationStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ReservationStatusEnum value) {
        this.status = value;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto value) {
        this.client = value;
    }
}