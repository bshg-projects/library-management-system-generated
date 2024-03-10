package org.bshg.librarysystem.webservice.dto.event;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.webservice.dto.user.ClientDto;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDto extends MoneyDto {
    public PaymentDto() {
        super();
    }

    private LocalDate paymentDate;
    private ClientDto client;

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate value) {
        this.paymentDate = value;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto value) {
        this.client = value;
    }
}