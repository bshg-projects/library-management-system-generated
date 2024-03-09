package org.bshg.librarysystem.publisher.webservice;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.create.CreatePublisherProcess;
import org.bshg.librarysystem.publisher.sprocess.update.UpdatePublisherProcess;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
import org.bshg.librarysystem.publisher.webservice.PublisherConverter;
import org.bshg.librarysystem.publisher.webservice.PublisherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/publisher")
public class PublisherRestApi {
protected PublisherService service;
protected PublisherConverter converter;
protected CreatePublisherProcess createProcess;
protected UpdatePublisherProcess updateProcess;
protected DeletePublisherProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<PublisherDto> findById(@PathVariable Long id) {
Publisher item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
PublisherDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<PublisherDto>> findAll() {
List<Publisher> all = service.findAll();
List<PublisherDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<PublisherDto>> findAllOptimized() {
List<Publisher> all = service.findAllOptimized();
List<PublisherDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<PublisherDto> save(@RequestBody PublisherDto dto) {
converter.init(true);
Publisher item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<PublisherDto>> save(@RequestBody List<PublisherDto> dtos) {
converter.init(true);
List<Publisher> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<PublisherDto> update(@RequestBody PublisherDto dto) {
converter.init(true);
Publisher item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<PublisherDto>> update(@RequestBody List<PublisherDto> dtos) {
converter.init(true);
List<Publisher> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<PublisherDto> delete(@RequestBody PublisherDto dto) {
converter.init(false);
Publisher item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<PublisherDto>> delete(@RequestBody List<PublisherDto> dtos) {
converter.init(false);
List<Publisher> items = converter.toItem(dtos);
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
public ResponseEntity<PublisherDto> findByAddressId(@PathVariable Long id){
Publisher item = service.findByAddressId(id);
PublisherDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
}