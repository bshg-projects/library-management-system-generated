package org.bshg.librarysystem.webservice.controller.library;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.webservice.converter.library.AddressConverter;
import org.bshg.librarysystem.webservice.dto.library.AddressDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/address")
public class AddressRestApi {
protected AddressService service;
protected AddressConverter converter;
protected CreateAddressProcess createProcess;
protected UpdateAddressProcess updateProcess;
protected DeleteAddressProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<AddressDto> findById(@PathVariable Long id) {
Address item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
AddressDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<AddressDto>> findAll() {
List<Address> all = service.findAll();
List<AddressDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<AddressDto>> findAllOptimized() {
List<Address> all = service.findAllOptimized();
List<AddressDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<AddressDto> save(@RequestBody AddressDto dto) {
converter.init(true);
Address item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<AddressDto>> save(@RequestBody List<AddressDto> dtos) {
converter.init(true);
List<Address> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<AddressDto> update(@RequestBody AddressDto dto) {
converter.init(true);
Address item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<AddressDto>> update(@RequestBody List<AddressDto> dtos) {
converter.init(true);
List<Address> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<AddressDto> delete(@RequestBody AddressDto dto) {
converter.init(false);
Address item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<AddressDto>> delete(@RequestBody List<AddressDto> dtos) {
converter.init(false);
List<Address> items = converter.toItem(dtos);
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
@DeleteMapping("/country/id/{id}")
public ResponseEntity<Long> deleteByCountryId(@PathVariable Long id){
service.deleteByCountryId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/country/id/{id}")
public ResponseEntity<List<AddressDto>> findByCountryId(@PathVariable Long id){
List<Address> items = service.findByCountryId(id);
List<AddressDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
}