package com.example.todosample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping("/todos")
    ResponseEntity getAllToDos(){
        return new ResponseEntity(toDoService.findAllToDos(), HttpStatus.OK);
    }
}
