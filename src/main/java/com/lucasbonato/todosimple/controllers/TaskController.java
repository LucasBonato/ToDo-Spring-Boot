package com.lucasbonato.todosimple.controllers;

import com.lucasbonato.todosimple.models.Task;
import com.lucasbonato.todosimple.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
        Task task = taskService.findById(id);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> findTasksByUserId(@PathVariable Long userId) {
        List<Task> taskList = taskService.findAllTasksByUserId(userId);
        return ResponseEntity.ok().body(taskList);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Void> createTask(@RequestBody @Valid Task task) {
        taskService.createTask(task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<Void> updateTask(@RequestBody @Valid Task task, @PathVariable Long id) {
        task.setId(id);
        taskService.updateTask(task);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}