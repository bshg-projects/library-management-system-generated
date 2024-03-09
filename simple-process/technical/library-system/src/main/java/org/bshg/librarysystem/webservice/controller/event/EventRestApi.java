package org.bshg.librarysystem.webservice.controller.event;
import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.services.facade.event.EventService;
import org.bshg.librarysystem.sprocess.event.event.facade.CreateEventProcess;
import org.bshg.librarysystem.sprocess.event.event.facade.UpdateEventProcess;
import org.bshg.librarysystem.sprocess.event.event.facade.DeleteEventProcess;
import org.bshg.librarysystem.webservice.converter.event.EventConverter;
import org.bshg.librarysystem.webservice.dto.event.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/event")
public class EventRestApi {
protected EventService service;
protected EventConverter converter;
protected CreateEventProcess createProcess;
protected UpdateEventProcess updateProcess;
protected DeleteEventProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<EventDto> findById(@PathVariable Long id) {
Event item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
EventDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<EventDto>> findAll() {
List<Event> all = service.findAll();
List<EventDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<EventDto>> findAllOptimized() {
List<Event> all = service.findAllOptimized();
List<EventDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<EventDto> save(@RequestBody EventDto dto) {
converter.init(true);
Event item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<EventDto>> save(@RequestBody List<EventDto> dtos) {
converter.init(true);
List<Event> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<EventDto> update(@RequestBody EventDto dto) {
converter.init(true);
Event item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<EventDto>> update(@RequestBody List<EventDto> dtos) {
converter.init(true);
List<Event> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<EventDto> delete(@RequestBody EventDto dto) {
converter.init(false);
Event item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<EventDto>> delete(@RequestBody List<EventDto> dtos) {
converter.init(false);
List<Event> items = converter.toItem(dtos);
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