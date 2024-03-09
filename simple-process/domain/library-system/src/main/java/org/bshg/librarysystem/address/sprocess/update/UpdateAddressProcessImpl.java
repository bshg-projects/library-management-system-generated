package org.bshg.librarysystem.address.sprocess.update;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UpdateAddressProcessImpl implements UpdateAddressProcess {
@Transactional(rollbackFor = Exception.class)
public Address run(Address item) { // Your Logic To Update 'Address'
item = service.edit(item);
return item;
}
public List<Address> run(List<Address> items) {
items.forEach(this::run);
return items;
}
@Autowired private AddressService service;
}