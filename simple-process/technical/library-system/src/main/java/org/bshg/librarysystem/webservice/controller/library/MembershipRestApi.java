package org.bshg.librarysystem.webservice.controller.library;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.services.facade.library.MembershipService;
import org.bshg.librarysystem.sprocess.library.membership.facade.CreateMembershipProcess;
import org.bshg.librarysystem.sprocess.library.membership.facade.UpdateMembershipProcess;
import org.bshg.librarysystem.sprocess.library.membership.facade.DeleteMembershipProcess;
import org.bshg.librarysystem.webservice.converter.library.MembershipConverter;
import org.bshg.librarysystem.webservice.dto.library.MembershipDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/membership")
public class MembershipRestApi {
protected MembershipService service;
protected MembershipConverter converter;
protected CreateMembershipProcess createProcess;
protected UpdateMembershipProcess updateProcess;
protected DeleteMembershipProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<MembershipDto> findById(@PathVariable Long id) {
Membership item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
MembershipDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<MembershipDto>> findAll() {
List<Membership> all = service.findAll();
List<MembershipDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<MembershipDto>> findAllOptimized() {
List<Membership> all = service.findAllOptimized();
List<MembershipDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<MembershipDto> save(@RequestBody MembershipDto dto) {
converter.init(true);
Membership item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<MembershipDto>> save(@RequestBody List<MembershipDto> dtos) {
converter.init(true);
List<Membership> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<MembershipDto> update(@RequestBody MembershipDto dto) {
converter.init(true);
Membership item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<MembershipDto>> update(@RequestBody List<MembershipDto> dtos) {
converter.init(true);
List<Membership> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<MembershipDto> delete(@RequestBody MembershipDto dto) {
converter.init(false);
Membership item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<MembershipDto>> delete(@RequestBody List<MembershipDto> dtos) {
converter.init(false);
List<Membership> items = converter.toItem(dtos);
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
public ResponseEntity<MembershipDto> findByClientId(@PathVariable Long id){
Membership item = service.findByClientId(id);
MembershipDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
}