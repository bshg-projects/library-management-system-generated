package org.bshg.librarysystem.sprocess.library.review.update;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.sprocess.library.review.update.UpdateReviewProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UpdateReviewProcessImpl implements UpdateReviewProcess {
@Transactional(rollbackFor = Exception.class)
public Review run(Review item) { // Your Logic To Update 'Review'
item = service.edit(item);
return item;
}
public List<Review> run(List<Review> items) {
items.forEach(this::run);
return items;
}
@Autowired private ReviewService service;
}