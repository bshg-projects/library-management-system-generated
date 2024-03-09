package org.bshg.librarysystem.magazine.webservice;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.create.CreateMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.update.UpdateMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.magazine.webservice.MagazineConverter;
import org.bshg.librarysystem.magazine.webservice.MagazineDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/magazine")
public class MagazineRestApi {
protected MagazineService service;
protected MagazineConverter converter;
protected CreateMagazineProcess createProcess;
protected UpdateMagazineProcess updateProcess;
protected DeleteMagazineProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<MagazineDto> findById(@PathVariable Long id) {
Magazine item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
MagazineDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<MagazineDto>> findAll() {
List<Magazine> all = service.findAll();
List<MagazineDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<MagazineDto>> findAllOptimized() {
List<Magazine> all = service.findAllOptimized();
List<MagazineDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<MagazineDto> save(@RequestBody MagazineDto dto) {
converter.init(true);
Magazine item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<MagazineDto>> save(@RequestBody List<MagazineDto> dtos) {
converter.init(true);
List<Magazine> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<MagazineDto> update(@RequestBody MagazineDto dto) {
converter.init(true);
Magazine item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<MagazineDto>> update(@RequestBody List<MagazineDto> dtos) {
converter.init(true);
List<Magazine> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<MagazineDto> delete(@RequestBody MagazineDto dto) {
converter.init(false);
Magazine item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<MagazineDto>> delete(@RequestBody List<MagazineDto> dtos) {
converter.init(false);
List<Magazine> items = converter.toItem(dtos);
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
@DeleteMapping("/genre/id/{id}")
public ResponseEntity<Long> deleteByGenreId(@PathVariable Long id){
service.deleteByGenreId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/genre/id/{id}")
public ResponseEntity<List<MagazineDto>> findByGenreId(@PathVariable Long id){
List<Magazine> items = service.findByGenreId(id);
List<MagazineDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
@DeleteMapping("/publisher/id/{id}")
public ResponseEntity<Long> deleteByPublisherId(@PathVariable Long id){
service.deleteByPublisherId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/publisher/id/{id}")
public ResponseEntity<List<MagazineDto>> findByPublisherId(@PathVariable Long id){
List<Magazine> items = service.findByPublisherId(id);
List<MagazineDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
}