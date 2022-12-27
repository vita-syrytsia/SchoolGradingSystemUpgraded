package com.schoolgrading.secondversion.student.loading.service;

import com.schoolgrading.secondversion.student.businessentity.Student;
import com.schoolgrading.secondversion.student.loading.port.in.LoadStudentUseCase;
import com.schoolgrading.secondversion.student.loading.port.out.LoadStudentAdapter;

public class LoadStudentService implements LoadStudentUseCase {
    private final LoadStudentAdapter loadStudentAdapter;

    public LoadStudentService(LoadStudentAdapter loadStudentAdapter) {
        this.loadStudentAdapter = loadStudentAdapter;
    }

    @Override
    public Student load(int studentId) {
        return loadStudentAdapter.load(studentId);
    }
}
