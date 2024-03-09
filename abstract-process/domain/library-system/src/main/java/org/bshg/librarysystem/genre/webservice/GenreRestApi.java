package org.bshg.librarysystem.genre.webservice;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcess;
import org.bshg.librarysystem.genre.sprocess.update.UpdateGenreProcess;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.genre.webservice.GenreConverter;
import org.bshg.librarysystem.genre.webservice.GenreDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/genre")
public class GenreRestApi extends AbstractRestApi<
Genre,
GenreDto,
GenreService,
GenreConverter,
CreateGenreProcess,
UpdateGenreProcess,
DeleteGenreProcess> {
public GenreRestApi( GenreService service, GenreConverter converter, CreateGenreProcess createProcess, UpdateGenreProcess updateProcess, DeleteGenreProcess deleteProcess) {
super(service, converter, createProcess, updateProcess, deleteProcess);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<GenreDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<GenreDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<GenreDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<GenreDto> save(@RequestBody GenreDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<GenreDto>> save(@RequestBody List<GenreDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<GenreDto> update(@RequestBody GenreDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<GenreDto>> update(@RequestBody List<GenreDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<GenreDto> delete(@RequestBody GenreDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<GenreDto>> delete(@RequestBody List<GenreDto> dtos) {
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