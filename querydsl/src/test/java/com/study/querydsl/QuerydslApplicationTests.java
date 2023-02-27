package com.study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.entity.Hello;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static com.study.querydsl.entity.QHello.hello;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class QuerydslApplicationTests {

    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {
        Hello originHello = new Hello();
        em.persist(originHello);

        JPAQueryFactory query = new JPAQueryFactory(em);
        Hello result = query
                .selectFrom(hello)
                .fetchOne();

        assertThat(result).isEqualTo(originHello);
        assertThat(result.getId()).isEqualTo(originHello.getId());
    }
}
