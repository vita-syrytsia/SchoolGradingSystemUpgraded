package com.schoolgrading.secondversion.student.administration.update;

import com.schoolgrading.secondversion.student.administration.port.in.update.UpdateStudentCommand;
import com.schoolgrading.secondversion.student.administration.port.out.update.UpdateStudentPort;
import com.schoolgrading.secondversion.student.businessentity.Student;

public class UpdateStudentAdapter implements UpdateStudentPort {
    @Override
    public Student update(UpdateStudentCommand updateStudentCommand) {
        return null;
    }
}
