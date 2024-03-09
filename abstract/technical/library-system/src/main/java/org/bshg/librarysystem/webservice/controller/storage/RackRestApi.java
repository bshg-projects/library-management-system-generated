package org.bshg.librarysystem.webservice.controller.storage;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.webservice.converter.storage.RackConverter;
import org.bshg.librarysystem.webservice.dto.storage.RackDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/rack")
public class RackRestApi extends AbstractRestApi<Rack,RackDto,RackService,RackConverter> {
public RackRestApi( RackService service, RackConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<RackDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<RackDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<RackDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<RackDto> save(@RequestBody RackDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<RackDto>> save(@RequestBody List<RackDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<RackDto> update(@RequestBody RackDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<RackDto>> update(@RequestBody List<RackDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<RackDto> delete(@RequestBody RackDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<RackDto>> delete(@RequestBody List<RackDto> dtos) {
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
@DeleteMapping("/shelf/id/{id}")
public ResponseEntity<Long> deleteByShelfId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByShelfId);
}
@GetMapping("/shelf/id/{id}")
public ResponseEntity<List<RackDto>> findByShelfId(@PathVariable Long id){
return super.findListByChildId(id, service::findByShelfId);
}
}