package org.example.expert.domain.todo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
//일정 제목
//담당자 수
//총 댓글 개수
public class TodoSearchResponse {
    Long id;
    String title;
    Long cntManager;
    Long cntComment;

}
