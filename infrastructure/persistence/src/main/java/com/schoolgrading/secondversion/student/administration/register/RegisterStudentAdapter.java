package com.schoolgrading.secondversion.student.administration.register;

import com.schoolgrading.secondversion.student.administration.port.in.register.RegisterStudentCommand;
import com.schoolgrading.secondversion.student.administration.port.out.register.RegisterStudentPort;
import com.schoolgrading.secondversion.student.businessentity.Student;

public class RegisterStudentAdapter implements RegisterStudentPort {
    @Override
    public Student register(RegisterStudentCommand registerStudentCommand) {
        return null;
    }
}
