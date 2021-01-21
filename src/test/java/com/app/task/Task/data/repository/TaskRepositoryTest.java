package com.app.task.Task.data.repository;

import com.app.task.Task.data.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createTaskTest(){

         Task task = Task.builder()
                        .name("clean my room")
                        .type("good")
                        .status("active")
                        .build();

         log.info("Task object created --> {}", task);

         taskRepository.save(task);

        log.info("Task object after created --> {}", task);


    }

}