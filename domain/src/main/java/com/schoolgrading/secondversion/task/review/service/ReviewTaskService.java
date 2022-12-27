package com.schoolgrading.secondversion.task.review.service;

import com.schoolgrading.secondversion.common.businessentity.Score;
import com.schoolgrading.secondversion.student.businessentity.Student;
import com.schoolgrading.secondversion.student.businessentity.StudentAssignment;
import com.schoolgrading.secondversion.student.loading.port.out.LoadStudentAdapter;
import com.schoolgrading.secondversion.task.businessentity.Assignment;
import com.schoolgrading.secondversion.task.businessentity.AssignmentStatus;
import com.schoolgrading.secondversion.common.exception.InputValidationException;
import com.schoolgrading.secondversion.task.exception.ObjectNotFoundException;
import com.schoolgrading.secondversion.task.loading.port.out.LoadAssignmentAdapter;
import com.schoolgrading.secondversion.task.review.port.in.ReviewTaskCommand;
import com.schoolgrading.secondversion.task.review.port.in.ReviewTaskUseCase;

public class ReviewTaskService implements ReviewTaskUseCase {
    private final LoadStudentAdapter loadStudentAdapter;
    private final LoadAssignmentAdapter loadAssignmentAdapter;

    public ReviewTaskService(LoadStudentAdapter loadStudentAdapter, LoadAssignmentAdapter loadAssignmentAdapter) {
        this.loadStudentAdapter = loadStudentAdapter;
        this.loadAssignmentAdapter = loadAssignmentAdapter;
    }

    @Override
    public StudentAssignment review(ReviewTaskCommand reviewTaskCommand) {
        final AssignmentStatus assignmentStatus = AssignmentStatus.getByName(reviewTaskCommand.getReviewStatus());
        final Score score = Score.getBySymbol(reviewTaskCommand.getScore());

        if (!assignmentStatus.isReviewStatus())
            throw new InputValidationException("Unable to submit a review with an inappropriate review status.");

        if (assignmentStatus == AssignmentStatus.REVIEWED && score == null)
            throw new InputValidationException("Unable to successfully pass a review without a specified score.");

        final Student student = loadStudentAdapter.load(reviewTaskCommand.getStudentId());
        final Assignment assignment = loadAssignmentAdapter.load(reviewTaskCommand.getAssignmentId());

        if (student == null)
            throw new ObjectNotFoundException("Student doesn't exist by the specified id.");

        if (assignment == null)
            throw new ObjectNotFoundException("Assignment doesn't exist by the specified id.");

        // store to db
        return student.setReviewStatus(assignment, assignmentStatus, score);
    }
}
