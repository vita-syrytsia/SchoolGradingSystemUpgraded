package com.schoolgrading.secondversion.student.businessentity;

import com.schoolgrading.secondversion.common.businessentity.Grade;
import com.schoolgrading.secondversion.common.businessentity.Score;
import com.schoolgrading.secondversion.task.businessentity.Assignment;
import com.schoolgrading.secondversion.task.businessentity.AssignmentStatus;
import com.schoolgrading.secondversion.task.exception.TaskValidationException;

public class Student {
    private final int id;
    private final String name;
    private final Grade grade;
    private final StudyJournal studyJournal = new StudyJournal();

    public Student(int id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public StudentAssignment assignTask(Assignment assignment) {
        if (grade != assignment.getGrade())
            throw new TaskValidationException("Unable to assign a task appointed to a different grade.");

        final var studentAssignment = new StudentAssignment(id, assignment);
        studentAssignment.setAssignmentStatus(AssignmentStatus.READY_TO_WORK);
        studyJournal.storeAssignment(studentAssignment);

        return studentAssignment;
    }

    public boolean completeTask(Assignment assignment) {
        validateAssignment(assignment);
        return studyJournal.completeAssignment(assignment.getId(),assignment.getGrade(), assignment.getSubject());
    }

    public StudentAssignment setReviewStatus(Assignment assignment, AssignmentStatus assignmentStatus, Score score) {
        validateAssignment(assignment);
        return studyJournal.reviewAssignment(assignment, assignmentStatus, score);
    }

    private void validateAssignment(Assignment assignment) {
        if (grade != assignment.getGrade())
            throw new TaskValidationException("Unable to change the task from a different grade.");

        if (!studyJournal.isTaskAssignedToTheStudent(assignment))
            throw new TaskValidationException("Unable to process the task that is not assigned to the student.");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }
}
