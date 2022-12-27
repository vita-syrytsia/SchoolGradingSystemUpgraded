package com.schoolgrading.secondversion.task.loading.port.in;

import com.schoolgrading.secondversion.task.businessentity.Assignment;

public interface LoadAssignmentUseCase {
    Assignment load(int assignmentId);
}
