package com.example.demo.member.application.port.in;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ModifyMemberCommand {
    @NotNull
    private final Long id;
    @NotNull
    private final String email;
    @NotNull
    private final String password;
    @NotNull
    private final String nickname;

    private final Boolean status;
}
