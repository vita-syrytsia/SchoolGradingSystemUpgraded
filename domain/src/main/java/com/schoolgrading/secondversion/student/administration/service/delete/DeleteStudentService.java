package com.schoolgrading.secondversion.student.administration.service.delete;

import com.schoolgrading.secondversion.student.administration.port.in.delete.DeleteStudentUseCase;
import com.schoolgrading.secondversion.student.administration.port.out.delete.DeleteStudentPort;

public class DeleteStudentService implements DeleteStudentUseCase {
    private final DeleteStudentPort deleteStudentPort;

    public DeleteStudentService(DeleteStudentPort deleteStudentPort) {
        this.deleteStudentPort = deleteStudentPort;
    }

    @Override
    public boolean delete(int studentId) {
        return deleteStudentPort.delete(studentId);
    }
}
