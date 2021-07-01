package com.kakao.test.repository;

import com.kakao.test.domain.Membership;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;



@Repository
public class MembershipRepository {

    @PersistenceContext
    EntityManager em;

    public void saveMemberShip(Membership membership)
    {
        em.persist(membership);
    }

    public Membership findOneMembership(Long seq)
    {
        return em.find(Membership.class, seq);
    }

    public List<Membership> findAllMembership(){
        return em.createQuery("select m from Membership m", Membership.class).getResultList();
    }

}
