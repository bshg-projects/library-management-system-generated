package org.bshg.librarysystem.magazine.webservice;

import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.create.CreateMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.update.UpdateMagazineProcess;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magazine")
public class MagazineRestApi extends AbstractRestApi<
        Magazine,
        MagazineDto,
        MagazineService,
        MagazineConverter,
        CreateMagazineProcess,
        UpdateMagazineProcess,
        DeleteMagazineProcess> {
    public MagazineRestApi(MagazineService service, MagazineConverter converter, CreateMagazineProcess createProcess, UpdateMagazineProcess updateProcess, DeleteMagazineProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<MagazineDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<MagazineDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<MagazineDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<MagazineDto> save(@RequestBody MagazineDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<MagazineDto>> save(@RequestBody List<MagazineDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<MagazineDto> update(@RequestBody MagazineDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<MagazineDto>> update(@RequestBody List<MagazineDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<MagazineDto> delete(@RequestBody MagazineDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<MagazineDto>> delete(@RequestBody List<MagazineDto> dtos) {
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

    @DeleteMapping("/genre/id/{id}")
    public ResponseEntity<Long> deleteByGenreId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByGenreId);
    }

    @GetMapping("/genre/id/{id}")
    public ResponseEntity<List<MagazineDto>> findByGenreId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByGenreId);
    }

    @DeleteMapping("/publisher/id/{id}")
    public ResponseEntity<Long> deleteByPublisherId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByPublisherId);
    }

    @GetMapping("/publisher/id/{id}")
    public ResponseEntity<List<MagazineDto>> findByPublisherId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByPublisherId);
    }
}