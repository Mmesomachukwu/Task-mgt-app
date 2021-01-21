package com.app.task.Task.data.repository;

import com.app.task.Task.data.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path ="tasks")
public interface TaskRepository extends JpaRepository<Task, Integer> {



}
