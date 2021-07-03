package com.kakao.test.repository;

import com.kakao.test.domain.Membership;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Member;
import java.util.List;



@Repository
public class MembershipRepository {

    @PersistenceContext
    EntityManager em;



    public void saveMemberShip(Membership membership)
    {
        em.persist(membership);
        em.flush();
        //em.close();
    }

    public Membership findOneMembership(Long seq)
    {
        return em.find(Membership.class, seq);
    }

    public List<Membership> findAllMembership(){
        return em.createQuery("select m from Membership m", Membership.class).getResultList();
    }

    public Membership findByMembershipId(String membershipId)
    {
        return em.createQuery("select m from Membership m where m.membershipId = :membershipId", Membership.class).setParameter("membershipId",membershipId).getSingleResult();
    }

    public void deleteMembership(Long seq){
        //em.remove(membership);
        Membership membership = em.find(Membership.class, seq);
        membership.setMembershipStatus("N");
        em.flush();
    }

    public void updateMembershipPoint(Long seq, int point)
    {
        Membership membership = em.find(Membership.class, seq);
        membership.setPoint(point);
        em.flush();
    }

}
