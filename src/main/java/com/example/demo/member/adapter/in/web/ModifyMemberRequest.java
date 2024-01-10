package com.example.demo.member.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyMemberRequest {

    private Long id;
    private String email;
    private String password;
    private String nickname;
    private Boolean status;
}
