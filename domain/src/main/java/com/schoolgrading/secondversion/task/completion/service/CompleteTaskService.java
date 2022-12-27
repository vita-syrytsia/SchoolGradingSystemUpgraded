package com.schoolgrading.secondversion.task.completion.service;

import com.schoolgrading.secondversion.student.businessentity.Student;
import com.schoolgrading.secondversion.student.loading.port.out.LoadStudentAdapter;
import com.schoolgrading.secondversion.task.businessentity.Assignment;
import com.schoolgrading.secondversion.task.completion.port.in.CompleteTaskCommand;
import com.schoolgrading.secondversion.task.completion.port.in.CompleteTaskUseCase;
import com.schoolgrading.secondversion.task.completion.port.out.CompleteTaskAdapter;
import com.schoolgrading.secondversion.task.exception.DeadlineExceedException;
import com.schoolgrading.secondversion.task.exception.ObjectNotFoundException;
import com.schoolgrading.secondversion.task.loading.port.out.LoadAssignmentAdapter;

public class CompleteTaskService implements CompleteTaskUseCase {
    private final LoadStudentAdapter loadStudentAdapter;
    private final LoadAssignmentAdapter loadAssignmentAdapter;
    private final CompleteTaskAdapter completeTaskAdapter;

    public CompleteTaskService(
        LoadStudentAdapter loadStudentAdapter,
        LoadAssignmentAdapter loadAssignmentAdapter,
        CompleteTaskAdapter completeTaskAdapter
    ) {
        this.loadStudentAdapter = loadStudentAdapter;
        this.loadAssignmentAdapter = loadAssignmentAdapter;
        this.completeTaskAdapter = completeTaskAdapter;
    }

    @Override
    public boolean complete(CompleteTaskCommand completeTaskCommand) {
        final Student student = loadStudentAdapter.load(completeTaskCommand.getStudentId());
        final Assignment assignment = loadAssignmentAdapter.load(completeTaskCommand.getAssignmentId());

        if (student == null)
            throw new ObjectNotFoundException("Student doesn't exist by the specified id.");

        if (assignment == null)
            throw new ObjectNotFoundException("Assignment doesn't exist by the specified id.");

        if (assignment.isDeadlineExceed())
            throw new DeadlineExceedException("Unable to complete a task with a deadline exceed.");

        final boolean completed = student.completeTask(assignment);

        if (completed)
            completeTaskAdapter.complete(completeTaskCommand);

        return completed;
    }

}
