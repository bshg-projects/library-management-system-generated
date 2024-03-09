package org.bshg.librarysystem.event.webservice;
import org.bshg.librarysystem.event.Event;
import org.bshg.librarysystem.event.services.EventService;
import org.bshg.librarysystem.event.webservice.EventConverter;
import org.bshg.librarysystem.event.webservice.EventDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/event")
public class EventRestApi extends AbstractRestApi<Event,EventDto,EventService,EventConverter> {
public EventRestApi( EventService service, EventConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<EventDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<EventDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<EventDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<EventDto> save(@RequestBody EventDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<EventDto>> save(@RequestBody List<EventDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<EventDto> update(@RequestBody EventDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<EventDto>> update(@RequestBody List<EventDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<EventDto> delete(@RequestBody EventDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<EventDto>> delete(@RequestBody List<EventDto> dtos) {
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