package com.kakao.test.controller;

import com.kakao.test.common.ListResponseDto;
import com.kakao.test.common.SingleResponseDto;
import com.kakao.test.domain.Membership;
import com.kakao.test.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class MembershipController {

    @Autowired
    MembershipService membershipService;

    @PostMapping(value="/membership", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResponseDto<Membership> enrollMembership(@RequestBody Membership membership)
    {
        SingleResponseDto response = new SingleResponseDto();
        Long seq = membershipService.enrollMembership(membership);
        Membership savedMembership = membershipService.findOneMembership(seq);
        System.out.println("membershipId : "+savedMembership.getMembershipId());
        System.out.println("membershipName : "+savedMembership.getMembershipName());
        if(savedMembership!=null) {
            response.setData(savedMembership);
        }
        return response;
    }

    @GetMapping(value="/membership", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ListResponseDto<Membership> findMemberships(){
        ListResponseDto<Membership> response = new ListResponseDto<>();
        List<Membership> membershipList = membershipService.findMemberships();
        response.setList(membershipList);
        return response;
    }


}
