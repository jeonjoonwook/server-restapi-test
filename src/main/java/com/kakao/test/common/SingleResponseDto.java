package com.kakao.test.common;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SingleResponseDto<T> extends CommonResponseDto {
    private T response;
}
