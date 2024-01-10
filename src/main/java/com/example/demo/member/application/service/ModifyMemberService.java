package com.example.demo.member.application.service;

import com.example.demo.member.adapter.out.persistence.MemberJpaEntity;
import com.example.demo.member.adapter.out.persistence.SpringDataMemberRepository;
import com.example.demo.member.application.port.in.ModifyMemberCommand;
import com.example.demo.member.application.port.in.ModifyMemberUseCase;
import com.example.demo.member.application.port.out.ModifyMemberPort;
import com.example.demo.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifyMemberService implements ModifyMemberUseCase {
    private final ModifyMemberPort modifyMemberPort;

    @Override
    public Member ModifyMember(ModifyMemberCommand command) {
        Member member = Member.builder()
                .id(command.getId())
                .email(command.getEmail())
                .nickname(command.getNickname())
                .password(command.getPassword())
                .status(command.getStatus())
                .build();

        MemberJpaEntity memberJpaEntity = modifyMemberPort.modifyMember(member);
        if (memberJpaEntity != null){
            return Member.builder()
                    .id(member.getId())
                    .email(member.getEmail())
                    .nickname(member.getNickname())
                    .password(member.getPassword())
                    .status(member.getStatus())
                    .build();
        }
        return null;
    }
}
