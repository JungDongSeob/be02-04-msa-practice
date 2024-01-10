package com.example.demo.member.application.port.out;

import com.example.demo.member.adapter.out.persistence.MemberJpaEntity;
import com.example.demo.member.domain.Member;

public interface ModifyMemberPort {
    MemberJpaEntity modifyMember(Member member);
}
