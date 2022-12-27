package com.schoolgrading.secondversion.task.review.port.in;

import com.schoolgrading.secondversion.student.businessentity.StudentAssignment;

public interface ReviewTaskUseCase {
    StudentAssignment review(ReviewTaskCommand reviewTaskCommand);
}
