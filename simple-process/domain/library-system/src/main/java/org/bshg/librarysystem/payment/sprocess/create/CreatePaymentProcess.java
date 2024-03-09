package org.bshg.librarysystem.payment.sprocess.create;
import org.bshg.librarysystem.payment.Payment;
import java.util.List;
public interface CreatePaymentProcess {
Payment run(Payment item);
List<Payment> run(List<Payment> items);
}