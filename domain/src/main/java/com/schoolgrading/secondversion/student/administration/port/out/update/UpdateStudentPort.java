package com.schoolgrading.secondversion.student.administration.port.out.update;

import com.schoolgrading.secondversion.student.administration.port.in.update.UpdateStudentCommand;
import com.schoolgrading.secondversion.student.businessentity.Student;

public interface UpdateStudentPort {
    Student update(UpdateStudentCommand updateStudentCommand);
}
