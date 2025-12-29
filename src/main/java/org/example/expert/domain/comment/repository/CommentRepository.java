package org.example.expert.domain.comment.repository;

import org.example.expert.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

<<<<<<< HEAD

    @Query("SELECT c FROM Comment c JOIN FETCH c.user WHERE c.todo.id = :todoId")
=======
    @Query("SELECT c FROM Comment c JOIN c.user WHERE c.todo.id = :todoId")
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
    List<Comment> findByTodoIdWithUser(@Param("todoId") Long todoId);
}
