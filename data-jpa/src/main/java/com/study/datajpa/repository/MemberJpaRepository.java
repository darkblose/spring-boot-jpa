package com.study.datajpa.repository;

import com.study.datajpa.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberJpaRepository {

    private final EntityManager em;

    @Transactional
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Transactional
    public void delete(Member member) {
        em.remove(member);
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public List<Member> findAll() {
        return em.createQuery(
                        "select m from Member m", Member.class)
                .getResultList();
    }

    public long count() {
        return em.createQuery(
                        "select count(m) from Member m", Long.class)
                .getSingleResult();
    }
}
