package com.schoolgrading.secondversion.student.businessentity;

import com.schoolgrading.secondversion.task.businessentity.Assignment;
import com.schoolgrading.secondversion.task.businessentity.AssignmentStatus;
import com.schoolgrading.secondversion.common.businessentity.Score;

public class StudentAssignment {
    private final int studentId;
    private final Assignment assignment;
    private AssignmentStatus assignmentStatus;
    private Score score;

    public StudentAssignment(int studentId, Assignment assignment) {
        this.studentId = studentId;
        this.assignment = assignment;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getAssignmentId() {
        return assignment.getId();
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public AssignmentStatus getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(AssignmentStatus assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
