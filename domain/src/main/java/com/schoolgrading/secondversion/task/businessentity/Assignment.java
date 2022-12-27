package com.schoolgrading.secondversion.task.businessentity;

import com.schoolgrading.secondversion.common.businessentity.Grade;
import com.schoolgrading.secondversion.common.businessentity.Subject;
import java.time.LocalDate;

public class Assignment {
    private final int id;
    private final LocalDate date;
    private final Grade grade;
    private final Subject subject;
    private final String description;
    private final AssignmentType type;
    private LocalDate dueDate;

    public Assignment(
        int id,
        LocalDate date,
        Grade grade,
        Subject subject,
        String description,
        AssignmentType type
    ) {
        this.id = id;
        this.date = date;
        this.grade = grade;
        this.subject = subject;
        this.description = description;
        this.type = type;
    }

    public boolean isDeadlineExceed() {
        return dueDate != null && dueDate.isBefore(LocalDate.now());
    }

    public int getId() {
        return id;
    }

    public Grade getGrade() {
        return grade;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public AssignmentType getType() {
        return type;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDate() {
        return date;
    }
}
