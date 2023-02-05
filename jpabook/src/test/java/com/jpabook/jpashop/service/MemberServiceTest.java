package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.exception.DuplicatedMemberException;
import com.jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");
        // when
        Long savedMemberId = memberService.join(member);
        // then
        assertThat(member).isEqualTo(memberService.findOne(savedMemberId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");
        // when
        memberService.join(member1);
//        memberService.join(member2);
//        assertThrows(DuplicatedMemberException.class, () -> memberService.join(member2));
        assertThatThrownBy(() -> memberService.join(member2)).isInstanceOf(DuplicatedMemberException.class);
        // then
//        fail("중복 회원 가입은 불가하다.");

    }

}