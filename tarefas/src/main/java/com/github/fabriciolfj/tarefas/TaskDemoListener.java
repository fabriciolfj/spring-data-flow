package com.github.fabriciolfj.tarefas;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;

@Log4j2
public class TaskDemoListener {

    @BeforeTask
    public void beforeTask(TaskExecution taskExecution) {
        log.debug("[@Before] - {}", taskExecution);
    }

    @AfterTask
    public void afterTask(TaskExecution taskExecution) {
        log.debug("[@AfterTask] - {}", taskExecution);
    }

    @FailedTask
    public void failedTask(TaskExecution taskExecution, Throwable throwable) {
        log.debug("[@FailedTask] - {}", taskExecution);
        log.debug("[@FailedTask] - {}", throwable);
    }
}
