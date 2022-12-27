package com.schoolgrading.secondversion.task.completion.port.in;

public class CompleteTaskCommand {
    private final int studentId;
    private final int assignmentId;

    public CompleteTaskCommand(int studentId, int assignmentId) {
        this.studentId = studentId;
        this.assignmentId = assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }
}
