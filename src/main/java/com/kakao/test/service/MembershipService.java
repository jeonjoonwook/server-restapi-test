package com.kakao.test.service;

import com.kakao.test.domain.Membership;
import com.kakao.test.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MembershipService {

    @Autowired
    MembershipRepository membershipRepository;

    public Long enrollMembership(Membership membership)
    {
        //validate
        membershipRepository.saveMemberShip(membership);
        return membership.getSeq();
    }

    public List<Membership> findMemberships(){
        return membershipRepository.findAllMembership();
    }

    public Membership findOneMembership(Long seq)
    {
        return membershipRepository.findOneMembership(seq);
    }

}
