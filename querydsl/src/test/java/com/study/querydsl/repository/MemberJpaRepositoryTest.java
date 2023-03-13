package com.study.querydsl.repository;

import com.study.querydsl.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void basicTest() throws Exception {
        // given
        Member member = new Member("member1", 10);
        memberJpaRepository.save(member);
        // when
        // then
        Member findMember = memberJpaRepository.findById(member.getId()).get();
        assertThat(findMember).isEqualTo(member);

        List<Member> result1 = memberJpaRepository.findAll();
        assertThat(result1).containsExactly(member);

        List<Member> result1_QueryDsl = memberJpaRepository.findAll_QueryDsl();
        assertThat(result1_QueryDsl).containsExactly(member);

        List<Member> result2 = memberJpaRepository.findByUsername("member1");
        assertThat(result2).containsExactly(member);

        List<Member> result2_QueryDsl = memberJpaRepository.findByUsername_QueryDsl("member1");
        assertThat(result2_QueryDsl).containsExactly(member);
    }
}