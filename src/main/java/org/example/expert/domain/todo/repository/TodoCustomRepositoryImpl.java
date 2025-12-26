package org.example.expert.domain.todo.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import static com.querydsl.core.types.ExpressionUtils.count;
import static org.example.expert.domain.todo.entity.QTodo.todo;
import static org.example.expert.domain.user.entity.QUser.user;
import static org.example.expert.domain.manager.entity.QManager.manager;
import static org.example.expert.domain.comment.entity.QComment.comment;
import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
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
                       Projections.constructor(
                               UserResponse.class,
                               user.id,
                               user.email,
                               user.nickname
                       ),
                       todo.createdAt,
                       todo.modifiedAt)
                       )
                .from(todo)
               .leftJoin(todo.user, user)
               .where(builder)
               .fetchOne();
    }

    @Override
    public Page<TodoSearchResponse> findTodosBySearchQuery(Pageable pageable,
                                                           String title,
                                                           LocalDateTime startDate,
                                                           String nickname) {
        BooleanBuilder builder = new BooleanBuilder();

        //담당자의 닉네임
        //제목으로 검색
        if (title != null && !title.isBlank()) {
            builder.and(todo.title.contains(title));
        }
        //담당자 닉네임
        if (nickname != null && !nickname.isBlank()) {
            builder.and(todo.user.nickname.contains(nickname));
        }
        //생성일 범위
        if (startDate != null) {
            builder.and(todo.createdAt.goe(startDate));
        }
        List<TodoSearchResponse> content =
                queryFactory.select(Projections
                                .constructor(TodoSearchResponse.class,
                                        todo.id,
                                        todo.title,
                                        manager.todo.id.countDistinct(),
                                        comment.todo.id.countDistinct()
                        ))
                        .from(todo)
                        .leftJoin(todo.managers, manager)
                        .leftJoin(todo.comments, comment)
                        .leftJoin(todo.user, user)
                        .where(builder)
                        .orderBy(todo.createdAt.desc())
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .groupBy(todo.id)
                        .fetch();

        long count = content.size();
        return new PageImpl<>(content,pageable, count);
    }

}
