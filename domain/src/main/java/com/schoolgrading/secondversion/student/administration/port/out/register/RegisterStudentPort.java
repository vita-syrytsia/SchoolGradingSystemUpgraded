package com.schoolgrading.secondversion.student.administration.port.out.register;

import com.schoolgrading.secondversion.student.administration.port.in.register.RegisterStudentCommand;
import com.schoolgrading.secondversion.student.businessentity.Student;

public interface RegisterStudentPort {
    Student register(RegisterStudentCommand registerStudentCommand);
}
