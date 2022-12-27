package com.schoolgrading.secondversion.student.administration.port.in.update;

import com.schoolgrading.secondversion.student.businessentity.Student;

public interface UpdateStudentUseCase {
    Student update(UpdateStudentCommand updateStudentCommand);
}
