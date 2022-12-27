package com.schoolgrading.secondversion.task.assignment.port.in;

public class AssignTaskCommand {
    private final int assignmentId;
    private final int studentId;

    public AssignTaskCommand(int assignmentId, int studentId) {
        this.assignmentId = assignmentId;
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }
}
