package com.schoolgrading.secondversion.task.completion.port.in;

public interface CompleteTaskUseCase {
    boolean complete(CompleteTaskCommand completeTaskCommand);
}
