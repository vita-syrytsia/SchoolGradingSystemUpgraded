package com.schoolgrading.secondversion.task.loading.service;

import com.schoolgrading.secondversion.task.businessentity.Assignment;
import com.schoolgrading.secondversion.task.loading.port.in.LoadAssignmentUseCase;
import com.schoolgrading.secondversion.task.loading.port.out.LoadAssignmentAdapter;

public class LoadAssignmentService implements LoadAssignmentUseCase {
    private final LoadAssignmentAdapter loadAssignmentAdapter;

    public LoadAssignmentService(LoadAssignmentAdapter loadAssignmentAdapter) {
        this.loadAssignmentAdapter = loadAssignmentAdapter;
    }

    @Override
    public Assignment load(int assignmentId) {
        return loadAssignmentAdapter.load(assignmentId);
    }
}
