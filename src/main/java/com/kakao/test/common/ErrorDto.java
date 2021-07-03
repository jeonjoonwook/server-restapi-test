package com.kakao.test.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    private String message ="";
    private int status;
}
