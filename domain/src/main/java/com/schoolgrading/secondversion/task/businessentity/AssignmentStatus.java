package com.schoolgrading.secondversion.task.businessentity;

import java.util.HashMap;
import java.util.Map;

public enum AssignmentStatus {
    NEW(false),
    READY_TO_WORK(false),
    COMPLETED(false),
    REJECTED(true),
    REVIEWED(true),
    SKIPPED(true),
    OVERDUE(true);

    private static final Map<String, AssignmentStatus> nameToAssignmentStatus = new HashMap<>();
    static {
        for (AssignmentStatus assignmentStatus : values()) {
            nameToAssignmentStatus.put(assignmentStatus.name(), assignmentStatus);
        }
    }

    private final boolean isReviewStatus;

    AssignmentStatus(boolean isReviewStatus) {
        this.isReviewStatus = isReviewStatus;
    }

    public static AssignmentStatus getByName(String name) {
        return nameToAssignmentStatus.get(name);
    }

    public boolean isReviewStatus() {
        return isReviewStatus;
    }
}
