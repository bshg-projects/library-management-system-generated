package org.bshg.librarysystem.webservice.controller.event;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.sprocess.event.payment.facade.CreatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.facade.UpdatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.facade.DeletePaymentProcess;
import org.bshg.librarysystem.webservice.converter.event.PaymentConverter;
import org.bshg.librarysystem.webservice.dto.event.PaymentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/payment")
public class PaymentRestApi {
protected PaymentService service;
protected PaymentConverter converter;
protected CreatePaymentProcess createProcess;
protected UpdatePaymentProcess updateProcess;
protected DeletePaymentProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<PaymentDto> findById(@PathVariable Long id) {
Payment item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
PaymentDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<PaymentDto>> findAll() {
List<Payment> all = service.findAll();
List<PaymentDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<PaymentDto>> findAllOptimized() {
List<Payment> all = service.findAllOptimized();
List<PaymentDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<PaymentDto> save(@RequestBody PaymentDto dto) {
converter.init(true);
Payment item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<PaymentDto>> save(@RequestBody List<PaymentDto> dtos) {
converter.init(true);
List<Payment> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<PaymentDto> update(@RequestBody PaymentDto dto) {
converter.init(true);
Payment item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<PaymentDto>> update(@RequestBody List<PaymentDto> dtos) {
converter.init(true);
List<Payment> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<PaymentDto> delete(@RequestBody PaymentDto dto) {
converter.init(false);
Payment item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<PaymentDto>> delete(@RequestBody List<PaymentDto> dtos) {
converter.init(false);
List<Payment> items = converter.toItem(dtos);
deleteProcess.run(items);
return ResponseEntity.ok(dtos);
}
@DeleteMapping("/id/{id}")
public ResponseEntity<Long> deleteById(@PathVariable Long id) {
deleteProcess.run(id);
return ResponseEntity.ok(id);
}
@DeleteMapping("/ids")
public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
deleteProcess.runByIds(ids);
return ResponseEntity.ok(ids);
}
@DeleteMapping("/client/id/{id}")
public ResponseEntity<Long> deleteByClientId(@PathVariable Long id){
service.deleteByClientId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/client/id/{id}")
public ResponseEntity<List<PaymentDto>> findByClientId(@PathVariable Long id){
List<Payment> items = service.findByClientId(id);
List<PaymentDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
}