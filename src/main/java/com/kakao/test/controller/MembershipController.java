package com.kakao.test.controller;

import com.kakao.test.common.SingleResponseDto;
import com.kakao.test.domain.Membership;
import com.kakao.test.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
@SuppressWarnings("unchecked")
public class MembershipController {

    @Autowired
    MembershipService membershipService;

    @PostMapping("/membership")
    public SingleResponseDto<Membership> enrollMembership(@RequestBody Membership membership)
    {
        SingleResponseDto response = new SingleResponseDto();
        Long seq = membershipService.enrollMembership(membership);
        Membership savedMembership = membershipService.findOneMembership(seq);
        if(savedMembership!=null) {
            response.setData(savedMembership);
        }
        return response;
    }



}
