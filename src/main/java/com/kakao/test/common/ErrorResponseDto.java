package com.kakao.test.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto extends CommonResponseDto {

    private String message ="";
    private int status;
}
