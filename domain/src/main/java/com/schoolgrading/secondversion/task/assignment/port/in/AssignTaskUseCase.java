package com.schoolgrading.secondversion.task.assignment.port.in;

import com.schoolgrading.secondversion.student.businessentity.StudentAssignment;

public interface AssignTaskUseCase {
    StudentAssignment assign(AssignTaskCommand assignTaskCommand);
}
