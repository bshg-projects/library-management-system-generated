package org.bshg.librarysystem.payment.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.client.webservice.ClientDto;
import org.bshg.librarysystem.money.webservice.MoneyDto;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDto extends MoneyDto {
    private Long id;
    private LocalDate paymentDate;
    private ClientDto client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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