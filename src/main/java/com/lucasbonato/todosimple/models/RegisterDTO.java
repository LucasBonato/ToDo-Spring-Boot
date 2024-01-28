package com.lucasbonato.todosimple.models;

public record RegisterDTO(String username, String password, UserRoles role) { }