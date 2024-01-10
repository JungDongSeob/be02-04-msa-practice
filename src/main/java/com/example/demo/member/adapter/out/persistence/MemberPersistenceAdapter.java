package com.example.demo.member.adapter.out.persistence;

import com.example.demo.member.application.port.out.RegisterMemberPort;
import com.example.demo.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements RegisterMemberPort {
    private final SpringDataMemberRepository memberRepository;

    @Override
    public MemberJpaEntity createMember(Member member) {

        return  memberRepository.save(
                MemberJpaEntity.builder()
                        .email(member.getEmail())
                        .nickname(member.getNickname())
                        .password(member.getPassword())
                        .status(true)
                        .build()
        );

    }
}
