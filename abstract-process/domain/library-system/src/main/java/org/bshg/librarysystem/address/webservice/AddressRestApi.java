package org.bshg.librarysystem.address.webservice;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressRestApi extends AbstractRestApi<
        Address,
        AddressDto,
        AddressService,
        AddressConverter,
        CreateAddressProcess,
        UpdateAddressProcess,
        DeleteAddressProcess> {
    public AddressRestApi(AddressService service, AddressConverter converter, CreateAddressProcess createProcess, UpdateAddressProcess updateProcess, DeleteAddressProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<AddressDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<AddressDto> save(@RequestBody AddressDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<AddressDto>> save(@RequestBody List<AddressDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<AddressDto> update(@RequestBody AddressDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<AddressDto>> update(@RequestBody List<AddressDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<AddressDto> delete(@RequestBody AddressDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<AddressDto>> delete(@RequestBody List<AddressDto> dtos) {
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

    @DeleteMapping("/country/id/{id}")
    public ResponseEntity<Long> deleteByCountryId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByCountryId);
    }

    @GetMapping("/country/id/{id}")
    public ResponseEntity<List<AddressDto>> findByCountryId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByCountryId);
    }
}