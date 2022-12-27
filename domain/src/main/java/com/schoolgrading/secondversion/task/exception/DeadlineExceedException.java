package com.schoolgrading.secondversion.task.exception;

public class DeadlineExceedException extends RuntimeException {
    public DeadlineExceedException(String message) {
        super(message);
    }
}
