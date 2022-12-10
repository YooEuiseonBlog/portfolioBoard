package com.esy.portfolioboard.domain.service;

import com.esy.portfolioboard.domain.entity.Member;
import com.esy.portfolioboard.domain.repository.MemberRepository;
import com.esy.portfolioboard.web.form.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public void register(MemberForm form) {
        Member member = Member.builder()
                .build();
        memberRepository.save(member);
    }
}
