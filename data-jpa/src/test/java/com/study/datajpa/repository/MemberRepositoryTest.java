package com.study.datajpa.repository;

import com.study.datajpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member("memberA");
        // when
        Member savedMember = memberRepository.save(member);
        // then
        assertThat(savedMember).isEqualTo(member);
    }

    @Test
    public void 회원찾기() throws Exception {
        // given
        Member member = new Member("memberA");
        // when
        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(savedMember.getId()).get();
        // then
        assertThat(findMember).isEqualTo(member);
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    }

}