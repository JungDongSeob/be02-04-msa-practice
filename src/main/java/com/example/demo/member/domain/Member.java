package com.example.demo.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@Getter
@AllArgsConstructor
public class Member {
    private final Integer id;
    private final String email;
    private final String password;
    private final String nickname;
    private final Boolean status;

    //엔티티가 아님 도메인이지
}
