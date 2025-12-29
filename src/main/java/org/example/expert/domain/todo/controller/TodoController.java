package org.example.expert.domain.todo.controller;

<<<<<<< HEAD
import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
=======
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
import org.example.expert.domain.common.annotation.Auth;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.todo.dto.request.TodoSaveRequest;
import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.dto.response.TodoSaveResponse;
<<<<<<< HEAD
import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.example.expert.domain.todo.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
=======
import org.example.expert.domain.todo.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveResponse> saveTodo(
<<<<<<< HEAD
            @AuthenticationPrincipal AuthUser authUser,
=======
            @Auth AuthUser authUser,
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
            @Valid @RequestBody TodoSaveRequest todoSaveRequest
    ) {
        return ResponseEntity.ok(todoService.saveTodo(authUser, todoSaveRequest));
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<TodoResponse>> getTodos(
            @RequestParam(defaultValue = "1") int page,
<<<<<<< HEAD
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String weather,
            @RequestParam(defaultValue = "")LocalDateTime startDate,
            @RequestParam(defaultValue = "")LocalDateTime endDate
            ) {
        return ResponseEntity.ok(todoService.getTodos(page, size, weather, startDate, endDate));
=======
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(todoService.getTodos(page, size));
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<TodoResponse> getTodo(@PathVariable long todoId) {
        return ResponseEntity.ok(todoService.getTodo(todoId));
    }
<<<<<<< HEAD

    @GetMapping("/todos/search")
    public ResponseEntity<Page<TodoSearchResponse>> todoSearch(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String nickname,
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "") LocalDateTime startDate
    ) {
        return ResponseEntity.ok(todoService.todoSearch(page, size, title, startDate,nickname));
    }
=======
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
}
