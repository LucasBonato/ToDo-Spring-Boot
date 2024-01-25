package com.lucasbonato.todosimple.services;

import com.lucasbonato.todosimple.models.Task;
import com.lucasbonato.todosimple.models.User;
import com.lucasbonato.todosimple.repositories.TaskRepository;
import com.lucasbonato.todosimple.services.exceptions.DataBindingViolationException;
import com.lucasbonato.todosimple.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    public List<Task> findAllTasksByUserId(Long userId) {
        return taskRepository.findByUser_Id(userId);
    }

    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new ObjectNotFoundException("Tarefa não encontrada."));
    }

    @Transactional
    public Task createTask(Task task) {
        User user = userService.findById(task.getUser().getId());
        task.setId(null);
        task.setUser(user);
        task = taskRepository.save(task);
        return task;
    }

    @Transactional
    public Task updateTask(Task task) {
        Task taskToUpdate = findById(task.getId());
        taskToUpdate.setDescription(task.getDescription());
        return taskRepository.save(taskToUpdate);
    }

    public void delete(Long id) {
        findById(id);
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Não é possível deletar, pois há entidades relacionadas.");
        }
    }

}