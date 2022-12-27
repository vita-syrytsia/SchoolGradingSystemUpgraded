package com.schoolgrading.secondversion.student.administration.port.in.register;

import com.schoolgrading.secondversion.common.exception.InputValidationException;
import static com.schoolgrading.secondversion.common.businessentity.Grade.doesGradeExistByNumber;

public class RegisterStudentCommand {
    private final String name;
    private final int gradeNumber;

    public RegisterStudentCommand(String name, int gradeNumber) {
        if (name == null || name.isBlank())
            throw new InputValidationException("Cannot create a student with an empty name.");

        if (!doesGradeExistByNumber(gradeNumber))
            throw new InputValidationException("Cannot create a student with non existent grade.");

        this.name = name;
        this.gradeNumber = gradeNumber;
    }

    public String getName() {
        return name;
    }

    public int getGradeNumber() {
        return gradeNumber;
    }
}
