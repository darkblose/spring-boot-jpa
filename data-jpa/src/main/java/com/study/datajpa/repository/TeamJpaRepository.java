package com.study.datajpa.repository;

import com.study.datajpa.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamJpaRepository {
    private final EntityManager em;

    @Transactional
    public Team save(Team team) {
        em.persist(team);
        return team;
    }

    @Transactional
    public void delete(Team team) {
        em.remove(team);
    }

    public List<Team> findAll() {
        return em.createQuery(
                        "select t from Team t", Team.class)
                .getResultList();
    }

    public Optional<Team> findById(Long id) {
        Team team = em.find(Team.class, id);
        return Optional.ofNullable(team);
    }

    public long count() {
        return em.createQuery(
                        "select count(t) from Team t", Long.class)
                .getSingleResult();
    }
}
