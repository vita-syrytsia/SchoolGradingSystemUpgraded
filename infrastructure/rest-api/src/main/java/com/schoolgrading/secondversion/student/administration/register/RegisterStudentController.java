package com.schoolgrading.secondversion.student.administration.register;

import com.schoolgrading.secondversion.student.administration.port.in.register.RegisterStudentCommand;
import com.schoolgrading.secondversion.student.administration.port.out.register.RegisterStudentPort;
import com.schoolgrading.secondversion.student.businessentity.Student;

public class RegisterStudentController {
    private final RegisterStudentPort registerStudentPort;

    public RegisterStudentController(RegisterStudentPort registerStudentPort) {
        this.registerStudentPort = registerStudentPort;
    }

    public Student register(RegisterStudentCommand registerStudentCommand) {
        return registerStudentPort.register(registerStudentCommand);
    }
}
