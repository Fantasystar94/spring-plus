package org.example.expert.domain.todo.service;

import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;
=======
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
import org.example.expert.client.WeatherClient;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.common.exception.InvalidRequestException;
import org.example.expert.domain.todo.dto.request.TodoSaveRequest;
import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.dto.response.TodoSaveResponse;
<<<<<<< HEAD
import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
=======
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.todo.repository.TodoRepository;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
=======
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
public class TodoService {

    private final TodoRepository todoRepository;
    private final WeatherClient weatherClient;

    public TodoSaveResponse saveTodo(AuthUser authUser, TodoSaveRequest todoSaveRequest) {
<<<<<<< HEAD
        User user = User.fromAuthUser(authUser);    //security Authentication
=======
        User user = User.fromAuthUser(authUser);
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079

        String weather = weatherClient.getTodayWeather();

        Todo newTodo = new Todo(
                todoSaveRequest.getTitle(),
                todoSaveRequest.getContents(),
                weather,
                user
        );
        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponse(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getContents(),
                weather,
<<<<<<< HEAD
                new UserResponse(user.getId(), user.getEmail(), user.getNickname())
        );
    }

    public Page<TodoResponse> getTodos(int page, int size, String weather, LocalDateTime startDate, LocalDateTime endDate) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Todo> todos;

        //웨더도 있고 날짜조건도 있음
        if (weather != null && !weather.isBlank() && (startDate != null && endDate != null)) {
            todos = todoRepository.findTodoByWeatherAndDate(weather,startDate,endDate,pageable);
        } else if (weather != null && !weather.isBlank()) {//웨더만 있음
            todos = todoRepository.findTodoWithWeather(weather,pageable);
        } else if (startDate != null || endDate != null) {//웨더는 없고, 날짜조건만 있음
            if (endDate == null) {
                todos = todoRepository.findTodoByStartDate(startDate, pageable);
            } else if (startDate == null) {
                todos = todoRepository.findTodoByEndDate(endDate, pageable);
            } else {
                todos = todoRepository.findTodoWithStartwithEndDate(startDate,endDate,pageable);
            }
        } else { //아무것도 없음
            todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);
        }
=======
                new UserResponse(user.getId(), user.getEmail())
        );
    }

    public Page<TodoResponse> getTodos(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079

        return todos.map(todo -> new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getContents(),
                todo.getWeather(),
<<<<<<< HEAD
                new UserResponse(todo.getUser().getId(), todo.getUser().getEmail(),todo.getUser().getNickname()),
=======
                new UserResponse(todo.getUser().getId(), todo.getUser().getEmail()),
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
                todo.getCreatedAt(),
                todo.getModifiedAt()
        ));
    }

    public TodoResponse getTodo(long todoId) {
<<<<<<< HEAD
        return todoRepository.findByIdWithUserWithDsl(todoId);
    }
    /*
    * - 검색 조건은 다음과 같아요.
    - 검색 키워드로 일정의 제목을 검색할 수 있어요.
        - 제목은 부분적으로 일치해도 검색이 가능해요.
    - 일정의 생성일 범위로 검색할 수 있어요.
        - 일정을 생성일 최신순으로 정렬해주세요.
    - 담당자의 닉네임으로도 검색이 가능해요.
        - 닉네임은 부분적으로 일치해도 검색이 가능해요.
- 다음의 내용을 포함해서 검색 결과를 반환해주세요.
    - 일정에 대한 모든 정보가 아닌, 제목만 넣어주세요.
    - 해당 일정의 담당자 수를 넣어주세요.
    - 해당 일정의 총 댓글 개수를 넣어주세요.
- 검색 결과는 페이징 처리되어 반환되도록 합니다.
    * */
    public Page<TodoSearchResponse> todoSearch(int page, int size, String title, LocalDateTime startDate, String nickname) {
        Pageable pageable = PageRequest.of(page - 1, size);
        log.info("title:{}",title);
        return todoRepository.findTodosBySearchQuery(pageable, title, startDate, nickname);
=======
        Todo todo = todoRepository.findByIdWithUser(todoId)
                .orElseThrow(() -> new InvalidRequestException("Todo not found"));

        User user = todo.getUser();

        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getContents(),
                todo.getWeather(),
                new UserResponse(user.getId(), user.getEmail()),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
    }
}
