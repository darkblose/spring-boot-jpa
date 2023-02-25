package com.study.datajpa.repository;

import com.study.datajpa.entity.Member;
import com.study.datajpa.entity.Team;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class MemberSpec {
    public static Specification<Member> teamName(final String teamName) {
        return (root, query, builder) -> {

            if (StringUtils.hasText(teamName)) {
                Join<Member, Team> t = root.join("team", JoinType.INNER);//회원과 조인
                return builder.equal(t.get("name"), teamName);
            }
            return null;
        };
    }

    public static Specification<Member> username(final String username) {
        return (root, query, builder) -> {
            if (StringUtils.hasText(username)) {
                return builder.equal(root.get("username"), username);
            }
            return null;
        };
    }
}
