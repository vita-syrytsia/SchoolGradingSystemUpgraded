package com.schoolgrading.secondversion.student.administration.delete;

import com.schoolgrading.secondversion.student.administration.port.out.delete.DeleteStudentPort;

public class DeleteStudentController {
    private final DeleteStudentPort deleteStudentPort;

    public DeleteStudentController(DeleteStudentPort deleteStudentPort) {
        this.deleteStudentPort = deleteStudentPort;
    }

    public boolean delete(int studentId) {
        return deleteStudentPort.delete(studentId);
    }
}
