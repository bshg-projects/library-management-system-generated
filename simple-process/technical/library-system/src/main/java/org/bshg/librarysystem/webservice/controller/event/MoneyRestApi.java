package org.bshg.librarysystem.webservice.controller.event;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.services.facade.event.MoneyService;
import org.bshg.librarysystem.sprocess.event.money.facade.CreateMoneyProcess;
import org.bshg.librarysystem.sprocess.event.money.facade.UpdateMoneyProcess;
import org.bshg.librarysystem.sprocess.event.money.facade.DeleteMoneyProcess;
import org.bshg.librarysystem.webservice.converter.event.MoneyConverter;
import org.bshg.librarysystem.webservice.dto.event.MoneyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/money")
public class MoneyRestApi {
protected MoneyService service;
protected MoneyConverter converter;
protected CreateMoneyProcess createProcess;
protected UpdateMoneyProcess updateProcess;
protected DeleteMoneyProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<MoneyDto> findById(@PathVariable Long id) {
Money item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
MoneyDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<MoneyDto>> findAll() {
List<Money> all = service.findAll();
List<MoneyDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<MoneyDto>> findAllOptimized() {
List<Money> all = service.findAllOptimized();
List<MoneyDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<MoneyDto> save(@RequestBody MoneyDto dto) {
converter.init(true);
Money item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<MoneyDto>> save(@RequestBody List<MoneyDto> dtos) {
converter.init(true);
List<Money> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<MoneyDto> update(@RequestBody MoneyDto dto) {
converter.init(true);
Money item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<MoneyDto>> update(@RequestBody List<MoneyDto> dtos) {
converter.init(true);
List<Money> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<MoneyDto> delete(@RequestBody MoneyDto dto) {
converter.init(false);
Money item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<MoneyDto>> delete(@RequestBody List<MoneyDto> dtos) {
converter.init(false);
List<Money> items = converter.toItem(dtos);
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
}