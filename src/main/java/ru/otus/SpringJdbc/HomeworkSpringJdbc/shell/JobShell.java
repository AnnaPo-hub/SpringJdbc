package ru.otus.SpringJdbc.HomeworkSpringJdbc.shell;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@Slf4j
@RequiredArgsConstructor
public class JobShell {

    private final Job bookJob;
    private final JobLauncher jobLauncher;

    @ShellMethod(value = "startMigrationJobWithJobLauncher", key = "smj")
    public void startMigrationJobWithJobLauncher() throws Exception {
        jobLauncher.run(bookJob, new JobParametersBuilder().toJobParameters());
    }
}
