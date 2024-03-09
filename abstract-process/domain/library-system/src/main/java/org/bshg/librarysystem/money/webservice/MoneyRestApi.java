package org.bshg.librarysystem.money.webservice;
import org.bshg.librarysystem.money.Money;
import org.bshg.librarysystem.money.services.MoneyService;
import org.bshg.librarysystem.money.sprocess.create.CreateMoneyProcess;
import org.bshg.librarysystem.money.sprocess.update.UpdateMoneyProcess;
import org.bshg.librarysystem.money.sprocess.delete.DeleteMoneyProcess;
import org.bshg.librarysystem.money.webservice.MoneyConverter;
import org.bshg.librarysystem.money.webservice.MoneyDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/money")
public class MoneyRestApi extends AbstractRestApi<
Money,
MoneyDto,
MoneyService,
MoneyConverter,
CreateMoneyProcess,
UpdateMoneyProcess,
DeleteMoneyProcess> {
public MoneyRestApi( MoneyService service, MoneyConverter converter, CreateMoneyProcess createProcess, UpdateMoneyProcess updateProcess, DeleteMoneyProcess deleteProcess) {
super(service, converter, createProcess, updateProcess, deleteProcess);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<MoneyDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<MoneyDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<MoneyDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<MoneyDto> save(@RequestBody MoneyDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<MoneyDto>> save(@RequestBody List<MoneyDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<MoneyDto> update(@RequestBody MoneyDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<MoneyDto>> update(@RequestBody List<MoneyDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<MoneyDto> delete(@RequestBody MoneyDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<MoneyDto>> delete(@RequestBody List<MoneyDto> dtos) {
return super.delete(dtos);
}
@Override
@DeleteMapping("/id/{id}")
public ResponseEntity<Long> deleteById(@PathVariable Long id) {
return super.deleteById(id);
}
@Override
@DeleteMapping("/ids")
public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
return super.deleteByIdIn(ids);
}
}