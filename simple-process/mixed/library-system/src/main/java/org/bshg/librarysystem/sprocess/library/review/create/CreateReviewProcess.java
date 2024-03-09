package org.bshg.librarysystem.sprocess.library.review.create;
import org.bshg.librarysystem.entity.core.library.Review;
import java.util.List;
public interface CreateReviewProcess {
Review run(Review item);
List<Review> run(List<Review> items);
}