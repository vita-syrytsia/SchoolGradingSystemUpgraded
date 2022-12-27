package com.schoolgrading.secondversion.student.administration.port.in.register;

import com.schoolgrading.secondversion.student.businessentity.Student;

public interface RegisterStudentUseCase {
    Student register(RegisterStudentCommand registerStudentCommand);
}
