package com.schoolgrading.secondversion.student.administration.update;

import com.schoolgrading.secondversion.student.administration.port.in.update.UpdateStudentCommand;
import com.schoolgrading.secondversion.student.administration.port.out.update.UpdateStudentPort;
import com.schoolgrading.secondversion.student.businessentity.Student;

public class UpdateStudentController {
    private final UpdateStudentPort updateStudentPort;

    public UpdateStudentController(UpdateStudentPort updateStudentPort) {
        this.updateStudentPort = updateStudentPort;
    }

    public Student register(UpdateStudentCommand updateStudentCommand) {
        return updateStudentPort.update(updateStudentCommand);
    }
}
