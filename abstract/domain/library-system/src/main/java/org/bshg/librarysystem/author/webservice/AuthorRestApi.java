package org.bshg.librarysystem.author.webservice;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.author.webservice.AuthorConverter;
import org.bshg.librarysystem.author.webservice.AuthorDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/author")
public class AuthorRestApi extends AbstractRestApi<Author,AuthorDto,AuthorService,AuthorConverter> {
public AuthorRestApi( AuthorService service, AuthorConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<AuthorDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<AuthorDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<AuthorDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<AuthorDto> save(@RequestBody AuthorDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<AuthorDto>> save(@RequestBody List<AuthorDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<AuthorDto> update(@RequestBody AuthorDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<AuthorDto>> update(@RequestBody List<AuthorDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<AuthorDto> delete(@RequestBody AuthorDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<AuthorDto>> delete(@RequestBody List<AuthorDto> dtos) {
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