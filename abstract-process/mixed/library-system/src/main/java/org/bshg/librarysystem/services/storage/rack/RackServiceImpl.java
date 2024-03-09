package org.bshg.librarysystem.services.storage.rack;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.repository.storage.RackDao;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class RackServiceImpl extends ServiceImpl<Rack, RackDao> implements RackService {
public RackServiceImpl(RackDao dao) {
super(dao);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByShelfId(Long id){
return dao.deleteByShelfId(id);
}
@Override
public List<Rack> findByShelfId(Long id){
return dao.findByShelfId(id);
}
@Autowired private ShelfService shelfService;
}