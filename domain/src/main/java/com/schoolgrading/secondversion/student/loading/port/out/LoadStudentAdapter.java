package com.schoolgrading.secondversion.student.loading.port.out;

import com.schoolgrading.secondversion.student.businessentity.Student;

public interface LoadStudentAdapter {
    Student load(int studentId);
}
