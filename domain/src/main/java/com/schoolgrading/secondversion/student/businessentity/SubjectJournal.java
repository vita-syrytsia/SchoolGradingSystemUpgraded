package com.schoolgrading.secondversion.student.businessentity;

import com.schoolgrading.secondversion.common.businessentity.Subject;
import java.util.ArrayList;
import java.util.List;

public class SubjectJournal {
    private final Subject subject;
    private final List<StudentAssignment> assignments = new ArrayList<>();

    public SubjectJournal(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void storeAssignment(StudentAssignment assignment) {
        assignments.add(assignment);
    }

    public List<StudentAssignment> getAssignments() {
        return assignments;
    }
}
