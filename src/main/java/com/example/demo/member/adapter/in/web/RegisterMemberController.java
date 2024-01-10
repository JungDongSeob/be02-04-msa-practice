package com.example.demo.member.adapter.in.web;

import com.example.demo.member.application.port.in.RegisterMemberCommand;
import com.example.demo.member.application.port.in.RegisterMemberUseCase;
import com.example.demo.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterMemberController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @RequestMapping(method = RequestMethod.POST, value = "/member/signup")
    Member registerMember(@RequestBody RegisterMemberRequest request){
         RegisterMemberCommand command = RegisterMemberCommand.builder()
                .email(request.getEmail())
                .password(request.getPasswork())
                .nickname(request.getNickname())
                .status(true)
                .build();

        return registerMemberUseCase.registerMember(command);
    }
}
