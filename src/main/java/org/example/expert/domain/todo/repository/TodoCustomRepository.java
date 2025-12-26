package org.example.expert.domain.todo.repository;
import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoCustomRepository {
    TodoResponse findByIdWithUserWithDsl(Long id);
    Page<TodoSearchResponse> findTodosBySearchQuery(Pageable pageable, String title, LocalDateTime startDate, String nickname);
}
