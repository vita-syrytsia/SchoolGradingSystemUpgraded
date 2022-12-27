package com.schoolgrading.secondversion.student.administration.service.update;

import com.schoolgrading.secondversion.student.administration.port.in.update.UpdateStudentCommand;
import com.schoolgrading.secondversion.student.administration.port.in.update.UpdateStudentUseCase;
import com.schoolgrading.secondversion.student.administration.port.out.update.UpdateStudentPort;
import com.schoolgrading.secondversion.student.businessentity.Student;

public class UpdateStudentService implements UpdateStudentUseCase {
    private final UpdateStudentPort updateStudentPort;

    public UpdateStudentService(UpdateStudentPort updateStudentPort) {
        this.updateStudentPort = updateStudentPort;
    }

    @Override
    public Student update(UpdateStudentCommand updateStudentCommand) {
        return updateStudentPort.update(updateStudentCommand);
    }
}
