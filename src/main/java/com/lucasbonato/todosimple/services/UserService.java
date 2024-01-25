package com.lucasbonato.todosimple.services;

import com.lucasbonato.todosimple.models.User;
import com.lucasbonato.todosimple.repositories.TaskRepository;
import com.lucasbonato.todosimple.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    @Transactional
    public User createUser(@RequestBody @Valid User user) {
        user.setId(null);
        user = userRepository.save(user);
        return user;
    }

    @Transactional
    public User updateUser(@RequestBody @Valid User user) {
        User userToUpdate = findById(user.getId());
        userToUpdate.setPassword(user.getPassword());
        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        findById(id);
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}