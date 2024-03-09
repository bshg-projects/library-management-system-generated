package org.bshg.librarysystem.staff.webservice;
import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.staff.services.StaffService;
import org.bshg.librarysystem.staff.sprocess.create.CreateStaffProcess;
import org.bshg.librarysystem.staff.sprocess.update.UpdateStaffProcess;
import org.bshg.librarysystem.staff.sprocess.delete.DeleteStaffProcess;
import org.bshg.librarysystem.staff.webservice.StaffConverter;
import org.bshg.librarysystem.staff.webservice.StaffDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/staff")
public class StaffRestApi {
protected StaffService service;
protected StaffConverter converter;
protected CreateStaffProcess createProcess;
protected UpdateStaffProcess updateProcess;
protected DeleteStaffProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<StaffDto> findById(@PathVariable Long id) {
Staff item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
StaffDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<StaffDto>> findAll() {
List<Staff> all = service.findAll();
List<StaffDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<StaffDto>> findAllOptimized() {
List<Staff> all = service.findAllOptimized();
List<StaffDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<StaffDto> save(@RequestBody StaffDto dto) {
converter.init(true);
Staff item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<StaffDto>> save(@RequestBody List<StaffDto> dtos) {
converter.init(true);
List<Staff> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<StaffDto> update(@RequestBody StaffDto dto) {
converter.init(true);
Staff item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<StaffDto>> update(@RequestBody List<StaffDto> dtos) {
converter.init(true);
List<Staff> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<StaffDto> delete(@RequestBody StaffDto dto) {
converter.init(false);
Staff item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<StaffDto>> delete(@RequestBody List<StaffDto> dtos) {
converter.init(false);
List<Staff> items = converter.toItem(dtos);
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