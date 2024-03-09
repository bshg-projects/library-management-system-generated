package org.bshg.librarysystem.genre.webservice;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcess;
import org.bshg.librarysystem.genre.sprocess.update.UpdateGenreProcess;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.genre.webservice.GenreConverter;
import org.bshg.librarysystem.genre.webservice.GenreDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/genre")
public class GenreRestApi {
protected GenreService service;
protected GenreConverter converter;
protected CreateGenreProcess createProcess;
protected UpdateGenreProcess updateProcess;
protected DeleteGenreProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<GenreDto> findById(@PathVariable Long id) {
Genre item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
GenreDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<GenreDto>> findAll() {
List<Genre> all = service.findAll();
List<GenreDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<GenreDto>> findAllOptimized() {
List<Genre> all = service.findAllOptimized();
List<GenreDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<GenreDto> save(@RequestBody GenreDto dto) {
converter.init(true);
Genre item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<GenreDto>> save(@RequestBody List<GenreDto> dtos) {
converter.init(true);
List<Genre> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<GenreDto> update(@RequestBody GenreDto dto) {
converter.init(true);
Genre item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<GenreDto>> update(@RequestBody List<GenreDto> dtos) {
converter.init(true);
List<Genre> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<GenreDto> delete(@RequestBody GenreDto dto) {
converter.init(false);
Genre item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<GenreDto>> delete(@RequestBody List<GenreDto> dtos) {
converter.init(false);
List<Genre> items = converter.toItem(dtos);
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