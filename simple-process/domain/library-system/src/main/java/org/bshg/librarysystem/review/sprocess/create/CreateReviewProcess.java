package org.bshg.librarysystem.review.sprocess.create;

import org.bshg.librarysystem.review.Review;

import java.util.List;

public interface CreateReviewProcess {
    Review run(Review item);

    List<Review> run(List<Review> items);
}