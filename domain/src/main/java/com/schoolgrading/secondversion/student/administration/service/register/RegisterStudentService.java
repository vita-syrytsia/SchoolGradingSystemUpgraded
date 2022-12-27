package com.schoolgrading.secondversion.student.administration.service.register;

import com.schoolgrading.secondversion.student.administration.port.in.register.RegisterStudentCommand;
import com.schoolgrading.secondversion.student.administration.port.in.register.RegisterStudentUseCase;
import com.schoolgrading.secondversion.student.administration.port.out.register.RegisterStudentPort;
import com.schoolgrading.secondversion.student.businessentity.Student;

public class RegisterStudentService implements RegisterStudentUseCase {
    private final RegisterStudentPort registerStudentPort;

    public RegisterStudentService(RegisterStudentPort registerStudentPort) {
        this.registerStudentPort = registerStudentPort;
    }

    @Override
    public Student register(RegisterStudentCommand registerStudentCommand) {
        return registerStudentPort.register(registerStudentCommand);
    }
}
