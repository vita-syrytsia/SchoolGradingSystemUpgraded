package com.schoolgrading.secondversion.task.assignment.service.assigntask;

import com.schoolgrading.secondversion.student.businessentity.Student;
import com.schoolgrading.secondversion.student.businessentity.StudentAssignment;
import com.schoolgrading.secondversion.student.loading.port.out.LoadStudentAdapter;
import com.schoolgrading.secondversion.task.assignment.port.in.AssignTaskCommand;
import com.schoolgrading.secondversion.task.assignment.port.in.AssignTaskUseCase;
import com.schoolgrading.secondversion.task.assignment.port.out.AssignTaskAdapter;
import com.schoolgrading.secondversion.task.businessentity.Assignment;
import com.schoolgrading.secondversion.task.exception.DeadlineExceedException;
import com.schoolgrading.secondversion.task.exception.ObjectNotFoundException;
import com.schoolgrading.secondversion.task.loading.port.out.LoadAssignmentAdapter;

public class AssignTaskService implements AssignTaskUseCase {
    private final LoadStudentAdapter loadStudentAdapter;
    private final LoadAssignmentAdapter loadAssignmentAdapter;
    private final AssignTaskAdapter assignTaskAdapter;

    public AssignTaskService(
        LoadStudentAdapter loadStudentAdapter,
        LoadAssignmentAdapter loadAssignmentAdapter,
        AssignTaskAdapter assignTaskAdapter
    ) {
        this.loadStudentAdapter = loadStudentAdapter;
        this.loadAssignmentAdapter = loadAssignmentAdapter;
        this.assignTaskAdapter = assignTaskAdapter;
    }

    @Override
    public StudentAssignment assign(AssignTaskCommand assignTaskCommand) {
        final Student student = loadStudentAdapter.load(assignTaskCommand.getStudentId());
        final Assignment assignment = loadAssignmentAdapter.load(assignTaskCommand.getAssignmentId());

        if (student == null)
            throw new ObjectNotFoundException("Student doesn't exist by the specified id.");

        if (assignment == null)
            throw new ObjectNotFoundException("Assignment doesn't exist by the specified id.");

        if (assignment.isDeadlineExceed())
            throw new DeadlineExceedException("Unable to assign a task with a wrong (exceed) deadline.");

        final StudentAssignment studentAssignment = student.assignTask(assignment);
        assignTaskAdapter.storeStudentAssignment(studentAssignment);

        return studentAssignment;
    }
}
