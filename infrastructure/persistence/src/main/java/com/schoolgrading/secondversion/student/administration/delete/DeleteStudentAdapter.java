package com.schoolgrading.secondversion.student.administration.delete;

import com.schoolgrading.secondversion.student.administration.port.out.delete.DeleteStudentPort;

public class DeleteStudentAdapter implements DeleteStudentPort {
    @Override
    public boolean delete(int studentId) {
        return true;
    }
}
