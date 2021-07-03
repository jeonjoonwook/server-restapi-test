package com.kakao.test.service;

import com.kakao.test.domain.Membership;
import com.kakao.test.domain.param.AddPointParam;
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

    public Membership findByMembershipId(String membershipId){return membershipRepository.findByMembershipId(membershipId);}

    public Long deleteMembership(String membershipId){
        Membership membership = membershipRepository.findByMembershipId(membershipId);
        membershipRepository.deleteMembership(membership.getSeq());
        return membership.getSeq();
    }

    public void addPointMembership(AddPointParam addPointParam)
    {
        Membership membership = membershipRepository.findByMembershipId(addPointParam.getMembershipId());
        int point = membership.getPoint();
        point = point + addPointParam.getAmount()/100;
        membershipRepository.updateMembershipPoint(membership.getSeq(),point);
    }

}
