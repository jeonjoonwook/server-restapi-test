package com.kakao.test.controller;

import com.kakao.test.common.*;
import com.kakao.test.domain.Membership;
import com.kakao.test.domain.param.AddPointParam;
import com.kakao.test.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class MembershipController {

    @Autowired
    MembershipService membershipService;

    @PostMapping(value="/membership", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResponseDto<Membership> enrollMembership(@RequestBody Membership membership)
    {

        SingleResponseDto<Membership> result = new SingleResponseDto<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        membership.setUserId("test1");
        membership.setMembershipStatus("Y");
        membership.setStartDate("2021-06-20");

        Long seq = membershipService.enrollMembership(membership);
        Membership savedMembership = membershipService.findOneMembership(seq);


        if(savedMembership!=null) {
            result.setSuccess(true);
            result.setResponse(savedMembership);
        }else{
            result.setSuccess(false);
        }

        return result;
    }

    @GetMapping(value="/membership", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ListResponseDto<Membership> findMemberships(){
        ListResponseDto<Membership> result = new ListResponseDto<>();
        List<Membership> membershipList = membershipService.findMemberships();


        if(membershipList!=null)
        {
            result.setSuccess(true);
            result.setResponse(membershipList);
        }else{
            ErrorDto errorDto = new ErrorDto();
            errorDto.setMessage("membershipId must be provided");
            errorDto.setStatus(400);
            result.setError(errorDto);
        }
        return result;
    }
    @GetMapping(value="/membership/{membershipId}")
    public SingleResponseDto<Membership> findByMembershipId(@PathVariable("membershipId") String membershipId){
        SingleResponseDto result = new SingleResponseDto();
        Membership membership = membershipService.findByMembershipId(membershipId);

        if(membership!=null)
        {
            result.setSuccess(true);
            result.setResponse(membership);
        }

        return result;
    }

    @DeleteMapping(value="/membership/{membershipId}")
    public BooleanResponseDto deleteMembership(@PathVariable("membershipId") String membershipId){
        BooleanResponseDto result = new BooleanResponseDto();

        Long seq = membershipService.deleteMembership(membershipId);
        Membership membership = membershipService.findOneMembership(seq);
        if(membership.getMembershipStatus().equals("N")){
            result.setSuccess(true);
            result.setResponse(true);
        }

        return result;
    }

    @PutMapping(value="/membership/point" , consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BooleanResponseDto addPointMembership(@RequestBody AddPointParam addPointParam)
    {
        BooleanResponseDto result = new BooleanResponseDto();
        membershipService.addPointMembership(addPointParam);

        result.setResponse(true);
        result.setSuccess(true);

        return result;
    }



}
