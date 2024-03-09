package org.bshg.librarysystem.webservice.controller.library;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.services.facade.library.MembershipService;
import org.bshg.librarysystem.webservice.converter.library.MembershipConverter;
import org.bshg.librarysystem.webservice.dto.library.MembershipDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/membership")
public class MembershipRestApi extends AbstractRestApi<Membership,MembershipDto,MembershipService,MembershipConverter> {
public MembershipRestApi( MembershipService service, MembershipConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<MembershipDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<MembershipDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<MembershipDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<MembershipDto> save(@RequestBody MembershipDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<MembershipDto>> save(@RequestBody List<MembershipDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<MembershipDto> update(@RequestBody MembershipDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<MembershipDto>> update(@RequestBody List<MembershipDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<MembershipDto> delete(@RequestBody MembershipDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<MembershipDto>> delete(@RequestBody List<MembershipDto> dtos) {
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
@DeleteMapping("/client/id/{id}")
public ResponseEntity<Long> deleteByClientId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByClientId);
}
@GetMapping("/client/id/{id}")
public ResponseEntity<MembershipDto> findByClientId(@PathVariable Long id){
return super.findByChildId(id, service::findByClientId);
}
}