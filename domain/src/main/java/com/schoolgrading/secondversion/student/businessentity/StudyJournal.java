package com.schoolgrading.secondversion.student.businessentity;

import com.schoolgrading.secondversion.common.businessentity.Grade;
import com.schoolgrading.secondversion.common.businessentity.Score;
import com.schoolgrading.secondversion.common.businessentity.Subject;
import com.schoolgrading.secondversion.task.businessentity.Assignment;
import com.schoolgrading.secondversion.task.businessentity.AssignmentStatus;
import com.schoolgrading.secondversion.task.exception.TaskValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StudyJournal {
    private final Map<Grade, Map<Subject, SubjectJournal>> studyJournal = new HashMap<>();

    public void storeAssignment(StudentAssignment studentAssignment) {
        final Grade grade = studentAssignment.getAssignment().getGrade();
        final Subject subject = studentAssignment.getAssignment().getSubject();
        final Map<Subject, SubjectJournal> subjectMap = studyJournal.computeIfAbsent(grade, key -> new HashMap<>());
        final SubjectJournal subjectJournal = subjectMap.computeIfAbsent(subject, key -> new SubjectJournal(subject));
        subjectJournal.storeAssignment(studentAssignment);
    }

    public boolean completeAssignment(int assignmentId, Grade grade, Subject subject) {
        final Optional<StudentAssignment> studentAssignment = getAssignmentById(assignmentId, grade, subject);

        if (studentAssignment.isEmpty())
            return false;

        studentAssignment.get().setAssignmentStatus(AssignmentStatus.COMPLETED);
        return true;
    }

    public StudentAssignment reviewAssignment(Assignment assignment, AssignmentStatus status, Score score) {
        final Optional<StudentAssignment> studentAssignmentOptional = getAssignmentById(assignment.getId(), assignment.getGrade(), assignment.getSubject());

        if (studentAssignmentOptional.isEmpty())
            throw new TaskValidationException("Unable to process the task that is not assigned to the student.");

        final StudentAssignment studentAssignment = studentAssignmentOptional.get();
        studentAssignment.setAssignmentStatus(status);
        studentAssignment.setScore(score);
        return studentAssignment;
    }

    public boolean isTaskAssignedToTheStudent(Assignment assignment) {
        return getAssignmentById(assignment.getId(), assignment.getGrade(), assignment.getSubject()).isPresent();
    }

    private Optional<StudentAssignment> getAssignmentById(int assignmentId, Grade grade, Subject subject) {
        final Map<Subject, SubjectJournal> subjectMap = studyJournal.get(grade);

        if (subjectMap == null)
            return Optional.empty();

        final SubjectJournal subjectJournal = subjectMap.get(subject);

        if (subjectJournal == null)
            return Optional.empty();

        return subjectJournal.getAssignments()
            .stream()
            .filter(a -> a.getAssignmentId() == assignmentId)
            .findFirst();
    }
}
