package com.kakao.test.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Membership {

    @Id @GeneratedValue
    private Long seq;

    private String membershipId;

    private String userId;

    private String membershipName;

    private String startDate;

    private String membershipStatus;

    private int point;
}
