package com.schoolgrading.secondversion.task.completion.port.out;

import com.schoolgrading.secondversion.task.completion.port.in.CompleteTaskCommand;

public interface CompleteTaskAdapter {
    void complete(CompleteTaskCommand completeTaskCommand);
}
