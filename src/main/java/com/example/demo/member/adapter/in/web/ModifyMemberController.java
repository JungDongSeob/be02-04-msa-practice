package com.example.demo.member.adapter.in.web;

import com.example.demo.member.application.port.in.ModifyMemberCommand;
import com.example.demo.member.application.port.in.ModifyMemberUseCase;
import com.example.demo.member.application.port.in.RegisterMemberCommand;
import com.example.demo.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ModifyMemberController {
    private final ModifyMemberUseCase modifyMemberUseCase;

    @RequestMapping(method = RequestMethod.PATCH, value = "/member/modify")
    Member registerMember(@RequestBody ModifyMemberRequest request){
        ModifyMemberCommand command = ModifyMemberCommand.builder()
                .id(request.getId())
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .status(request.getStatus())
                .build();


        return modifyMemberUseCase.ModifyMember(command);

    }
}
