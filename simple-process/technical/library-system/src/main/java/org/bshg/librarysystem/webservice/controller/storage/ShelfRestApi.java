package org.bshg.librarysystem.webservice.controller.storage;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.CreateShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.UpdateShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.DeleteShelfProcess;
import org.bshg.librarysystem.webservice.converter.storage.ShelfConverter;
import org.bshg.librarysystem.webservice.dto.storage.ShelfDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/shelf")
public class ShelfRestApi {
protected ShelfService service;
protected ShelfConverter converter;
protected CreateShelfProcess createProcess;
protected UpdateShelfProcess updateProcess;
protected DeleteShelfProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<ShelfDto> findById(@PathVariable Long id) {
Shelf item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
ShelfDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<ShelfDto>> findAll() {
List<Shelf> all = service.findAll();
List<ShelfDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<ShelfDto>> findAllOptimized() {
List<Shelf> all = service.findAllOptimized();
List<ShelfDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<ShelfDto> save(@RequestBody ShelfDto dto) {
converter.init(true);
Shelf item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<ShelfDto>> save(@RequestBody List<ShelfDto> dtos) {
converter.init(true);
List<Shelf> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<ShelfDto> update(@RequestBody ShelfDto dto) {
converter.init(true);
Shelf item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<ShelfDto>> update(@RequestBody List<ShelfDto> dtos) {
converter.init(true);
List<Shelf> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<ShelfDto> delete(@RequestBody ShelfDto dto) {
converter.init(false);
Shelf item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<ShelfDto>> delete(@RequestBody List<ShelfDto> dtos) {
converter.init(false);
List<Shelf> items = converter.toItem(dtos);
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