package org.bshg.librarysystem.sprocess.library.review.facade;

import org.bshg.librarysystem.entity.core.library.Review;
import java.util.List;

public interface UpdateReviewProcess {
    Review run(Review item);
    List<Review> run(List<Review> items);
}
