package org.bshg.librarysystem.review.sprocess.update;

import org.bshg.librarysystem.review.Review;

import java.util.List;

public interface UpdateReviewProcess {
    Review run(Review item);

    List<Review> run(List<Review> items);
}
