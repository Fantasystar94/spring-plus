package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoCustomRepository {

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    @Query("SELECT t FROM Todo t " +
            "LEFT JOIN t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);

    //웨더만 있는 경우 검색
    @Query("select t from Todo t where t.weather =:weather")
    Page<Todo> findTodoWithWeather(@Param("weather")String weather, Pageable pageable);

    //수정일 기준만 있는 경우 검색
    @Query("select t from Todo t where t.modifiedAt between :startDate and :endDate")
    Page<Todo> findTodoWithStartwithEndDate(@Param("startDate")LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,Pageable pageable);

    //수정일중 시작일만 있는 경우 검색
    @Query("select t from Todo t where t.modifiedAt > :startDate")
    Page<Todo> findTodoByStartDate(@Param("startDate")LocalDateTime startDate,Pageable pageable);

    //수정일중 끝나는날만 있는 경우 검색
    @Query("select t from Todo t where t.modifiedAt < :endDate")
    Page<Todo> findTodoByEndDate(@Param("endDate")LocalDateTime endDate, Pageable pageable);

    //웨더도 있고 수정일도 있는 경우 검색
    @Query("select t from Todo t where t.weather =:weather and t.modifiedAt between  :startDate and :endDate")
    Page<Todo> findTodoByWeatherAndDate(@Param("weather")String weather, @Param("startDate")LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,Pageable pageable);
}
