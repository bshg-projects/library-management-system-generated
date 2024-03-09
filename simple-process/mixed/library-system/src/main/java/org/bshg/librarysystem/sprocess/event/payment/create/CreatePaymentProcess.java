package org.bshg.librarysystem.sprocess.event.payment.create;
import org.bshg.librarysystem.entity.core.event.Payment;
import java.util.List;
public interface CreatePaymentProcess {
Payment run(Payment item);
List<Payment> run(List<Payment> items);
}