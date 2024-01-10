package com.example.demo.member.application.service;

import com.example.demo.member.adapter.out.persistence.MemberJpaEntity;
import com.example.demo.member.application.port.in.RegisterMemberCommand;
import com.example.demo.member.application.port.in.RegisterMemberUseCase;
import com.example.demo.member.application.port.out.RegisterMemberPort;
import com.example.demo.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterMemberService implements RegisterMemberUseCase {

    private final RegisterMemberPort registerMemberPort;
    @Override
    public Member registerMember(RegisterMemberCommand command) {
        Member member = Member.builder()
                .email(command.getEmail())
                .nickname(command.getNickname())
                .status(command.getStatus())
                .password(command.getPassword())
                .build();
        MemberJpaEntity memberJpaEntity = registerMemberPort.createMember(member);

        return Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .status(member.getStatus())
                .nickname(member.getNickname())
                .build();
    }
}
