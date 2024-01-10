package com.example.demo.member.application.port.in;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterMemberCommand {
    @NotNull
    private final String email;
    @NotNull
    private final String password;
    @NotNull
    private final String nickname;

    private final Boolean status;

    public RegisterMemberCommand(String email, String password, String nickname, Boolean status) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.status = status;

        // TODO: 검증하는 코드 추가할 것

    }
}
