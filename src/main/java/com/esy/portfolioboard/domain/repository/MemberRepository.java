package com.esy.portfolioboard.domain.repository;

import com.esy.portfolioboard.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
