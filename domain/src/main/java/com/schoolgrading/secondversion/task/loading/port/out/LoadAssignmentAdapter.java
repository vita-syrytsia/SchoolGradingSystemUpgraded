package com.schoolgrading.secondversion.task.loading.port.out;

import com.schoolgrading.secondversion.task.businessentity.Assignment;

public interface LoadAssignmentAdapter {
    Assignment load(int assignmentId);
}
