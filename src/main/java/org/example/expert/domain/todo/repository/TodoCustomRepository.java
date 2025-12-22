package org.example.expert.domain.todo.repository;
import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.entity.Todo;
import java.util.Optional;

public interface TodoCustomRepository {
    TodoResponse findByIdWithUserWithDsl(Long id);
}
