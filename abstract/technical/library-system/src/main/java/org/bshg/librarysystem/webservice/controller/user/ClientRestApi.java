package org.bshg.librarysystem.webservice.controller.user;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.webservice.converter.user.ClientConverter;
import org.bshg.librarysystem.webservice.dto.user.ClientDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/client")
public class ClientRestApi extends AbstractRestApi<Client,ClientDto,ClientService,ClientConverter> {
public ClientRestApi( ClientService service, ClientConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<ClientDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<ClientDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<ClientDto> save(@RequestBody ClientDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<ClientDto>> save(@RequestBody List<ClientDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<ClientDto> update(@RequestBody ClientDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<ClientDto>> update(@RequestBody List<ClientDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<ClientDto> delete(@RequestBody ClientDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<ClientDto>> delete(@RequestBody List<ClientDto> dtos) {
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