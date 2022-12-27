package com.schoolgrading.secondversion.task.assignment.port.out;

import com.schoolgrading.secondversion.student.businessentity.StudentAssignment;

public interface AssignTaskAdapter {
    void storeStudentAssignment(StudentAssignment studentAssignment);
}
