package com.schoolgrading.secondversion.student.administration.port.in.update;

import com.schoolgrading.secondversion.common.exception.InputValidationException;
import static com.schoolgrading.secondversion.common.businessentity.Grade.doesGradeExistByNumber;

public class UpdateStudentCommand {
    private final int studentId;
    private final String name;
    private final int gradeNumber;

    public UpdateStudentCommand(int studentId, String name, int gradeNumber) {
        if (name == null || name.isBlank())
            throw new InputValidationException("Cannot set an empty name to a student.");

        if (!doesGradeExistByNumber(gradeNumber))
            throw new InputValidationException("Cannot set a non existent grade to a student.");

        this.studentId = studentId;
        this.name = name;
        this.gradeNumber = gradeNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getGradeNumber() {
        return gradeNumber;
    }
}
