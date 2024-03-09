package org.bshg.librarysystem.webservice.library.librarybranch;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.services.library.librarybranch.LibraryBranchService;
import org.bshg.librarysystem.sprocess.library.librarybranch.create.CreateLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.update.UpdateLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.delete.DeleteLibraryBranchProcess;
import org.bshg.librarysystem.webservice.library.librarybranch.LibraryBranchConverter;
import org.bshg.librarysystem.webservice.library.librarybranch.LibraryBranchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/librarybranch")
public class LibraryBranchRestApi {
protected LibraryBranchService service;
protected LibraryBranchConverter converter;
protected CreateLibraryBranchProcess createProcess;
protected UpdateLibraryBranchProcess updateProcess;
protected DeleteLibraryBranchProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<LibraryBranchDto> findById(@PathVariable Long id) {
LibraryBranch item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
LibraryBranchDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<LibraryBranchDto>> findAll() {
List<LibraryBranch> all = service.findAll();
List<LibraryBranchDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<LibraryBranchDto>> findAllOptimized() {
List<LibraryBranch> all = service.findAllOptimized();
List<LibraryBranchDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<LibraryBranchDto> save(@RequestBody LibraryBranchDto dto) {
converter.init(true);
LibraryBranch item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<LibraryBranchDto>> save(@RequestBody List<LibraryBranchDto> dtos) {
converter.init(true);
List<LibraryBranch> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<LibraryBranchDto> update(@RequestBody LibraryBranchDto dto) {
converter.init(true);
LibraryBranch item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<LibraryBranchDto>> update(@RequestBody List<LibraryBranchDto> dtos) {
converter.init(true);
List<LibraryBranch> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<LibraryBranchDto> delete(@RequestBody LibraryBranchDto dto) {
converter.init(false);
LibraryBranch item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<LibraryBranchDto>> delete(@RequestBody List<LibraryBranchDto> dtos) {
converter.init(false);
List<LibraryBranch> items = converter.toItem(dtos);
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
@DeleteMapping("/address/id/{id}")
public ResponseEntity<Long> deleteByAddressId(@PathVariable Long id){
service.deleteByAddressId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/address/id/{id}")
public ResponseEntity<LibraryBranchDto> findByAddressId(@PathVariable Long id){
LibraryBranch item = service.findByAddressId(id);
LibraryBranchDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
}