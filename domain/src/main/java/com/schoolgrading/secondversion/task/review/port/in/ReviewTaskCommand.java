package com.schoolgrading.secondversion.task.review.port.in;

import com.schoolgrading.secondversion.common.exception.InputValidationException;
import com.schoolgrading.secondversion.task.businessentity.AssignmentStatus;

public class ReviewTaskCommand {
    private final int assignmentId;
    private final int studentId;
    private final String reviewStatus;
    private final String score;

    public ReviewTaskCommand(int assignmentId, int studentId, String reviewStatus, String score) {
        if (AssignmentStatus.getByName(reviewStatus) == null)
            throw new InputValidationException("Unable to submit a review with non-existent status.");

        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.reviewStatus = reviewStatus;
        this.score = score;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public String getScore() {
        return score;
    }
}
