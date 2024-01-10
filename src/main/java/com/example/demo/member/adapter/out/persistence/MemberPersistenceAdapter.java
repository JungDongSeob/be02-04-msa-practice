package com.example.demo.member.adapter.out.persistence;

import com.example.demo.member.application.port.out.ModifyMemberPort;
import com.example.demo.member.application.port.out.RegisterMemberPort;
import com.example.demo.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements RegisterMemberPort, ModifyMemberPort {
    private final SpringDataMemberRepository memberRepository;

    @Override
    public MemberJpaEntity createMember(Member member) {

        return  memberRepository.save(
                MemberJpaEntity.builder()
                        .id(member.getId())
                        .email(member.getEmail())
                        .nickname(member.getNickname())
                        .password(member.getPassword())
                        .status(true)
                        .build()
        );

    }

    @Override
    public MemberJpaEntity modifyMember(Member member) {
        Optional<MemberJpaEntity> result = memberRepository.findById(member.getId());

        if (result.isPresent()){


            return memberRepository.save(MemberJpaEntity.builder()
                    .id(member.getId())
                    .email(member.getEmail())
                    .nickname(member.getNickname())
                    .password(member.getPassword())
                    .status(member.getStatus())
                    .build());
        }
        return null;
    }
}
