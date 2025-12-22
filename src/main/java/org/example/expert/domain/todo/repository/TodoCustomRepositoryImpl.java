package org.example.expert.domain.todo.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import static org.example.expert.domain.todo.entity.QTodo.todo;
import static org.example.expert.domain.user.entity.QUser.user;

import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TodoCustomRepositoryImpl implements TodoCustomRepository {
    private final JPAQueryFactory queryFactory;


    public TodoCustomRepositoryImpl (EntityManager entityManager) {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public TodoResponse findByIdWithUserWithDsl(Long id) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(todo.id.eq(id));

        return queryFactory
               .select(Projections.constructor(TodoResponse.class,
                       todo.id,
                       todo.title,
                       todo.contents,
                       todo.weather,
                       todo.user,
                       todo.createdAt,
                       todo.modifiedAt)
                       )
                .from(todo)
               .leftJoin(todo.user, user)
               .where(builder)
               .fetchOne();
    }

}
