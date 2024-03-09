package org.bshg.librarysystem.webservice.controller.storage;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.CreateShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.UpdateShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.DeleteShelfProcess;
import org.bshg.librarysystem.webservice.converter.storage.ShelfConverter;
import org.bshg.librarysystem.webservice.dto.storage.ShelfDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/shelf")
public class ShelfRestApi extends AbstractRestApi<
Shelf,
ShelfDto,
ShelfService,
ShelfConverter,
CreateShelfProcess,
UpdateShelfProcess,
DeleteShelfProcess> {
public ShelfRestApi( ShelfService service, ShelfConverter converter, CreateShelfProcess createProcess, UpdateShelfProcess updateProcess, DeleteShelfProcess deleteProcess) {
super(service, converter, createProcess, updateProcess, deleteProcess);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<ShelfDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<ShelfDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<ShelfDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<ShelfDto> save(@RequestBody ShelfDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<ShelfDto>> save(@RequestBody List<ShelfDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<ShelfDto> update(@RequestBody ShelfDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<ShelfDto>> update(@RequestBody List<ShelfDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<ShelfDto> delete(@RequestBody ShelfDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<ShelfDto>> delete(@RequestBody List<ShelfDto> dtos) {
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