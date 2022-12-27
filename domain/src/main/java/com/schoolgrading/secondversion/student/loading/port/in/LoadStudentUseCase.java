package com.schoolgrading.secondversion.student.loading.port.in;

import com.schoolgrading.secondversion.student.businessentity.Student;

public interface LoadStudentUseCase {
    Student load(int studentId);
}
